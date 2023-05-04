package site.engineertest.otpgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.engineertest.otpgenerator.entity.OneTimePassword;
import site.engineertest.otpgenerator.repository.OneTimePasswordRepository;

import java.util.Date;

@Service
public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    OneTimePasswordRepository oneTimePasswordRepository;

    OneTimePasswordHelperService oneTimePasswordHelperService;

    @Autowired
    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository){
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    public OneTimePassword returnOneTimePassword(){
        OneTimePassword oneTimePassword = new OneTimePassword();

        oneTimePassword.setOneTimePasswordCode(oneTimePasswordHelperService.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }
}
