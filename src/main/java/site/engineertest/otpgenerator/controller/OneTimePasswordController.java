package site.engineertest.otpgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.engineertest.otpgenerator.service.OneTimePasswordService;

@RestController
@RequestMapping("/api/v1/otp")
public class OneTimePasswordController {
    @Autowired
    public OneTimePasswordService oneTimePasswordService;

    @GetMapping("/create")
    @ResponseBody
    public Object getOneTimePassword(){
        try{
            return ResponseEntity.ok(oneTimePasswordService.returnOneTimePassword());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
