package site.engineertest.otpgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import site.engineertest.otpgenerator.entity.OneTimePassword;

public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {
}
