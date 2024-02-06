package com.nurserygarden.ecommerceapp.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    private final int MAX_SIZE = 3 * 1024;

    @Override
    public void initialize(ValidFile validFile) {

        log.info("File validator initialized!!");
    }


    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {


        log.info("Validating file");
        boolean result = true;

        if (multipartFile.isEmpty()) {

            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "{Empty file}"
                    )
                    .addConstraintViolation();
            result = false;
            return result;

        } else if (multipartFile.getSize() > MAX_SIZE) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "{Max file size exceeded}"
                    )
                    .addConstraintViolation();
            result = false;
            return result;

        }

        return result;
    }
}
