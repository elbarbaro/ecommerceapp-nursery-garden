package com.nurserygarden.ecommerceapp.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile[]> {

    private final int MAX_SIZE = 3 * 1024 * 1024;

    private String message;

    @Override
    public void initialize(ValidFile validFile) {
        this.message = validFile.message();
        log.info("File validator initialized!!");
    }

    @Override
    public boolean isValid(MultipartFile[] multipartFile, ConstraintValidatorContext context) {


        log.info("Validating file");
        boolean result = true;

        if (multipartFile.length > 3) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "{Max amount of images allowed is 3}"
            ).addConstraintViolation();
            result = false;
        }
        for (MultipartFile file : multipartFile
        ) {
            if (file.isEmpty()) {

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "{Empty file}"
                ).addConstraintViolation();
                result = false;

            }
            if (file.getSize() > MAX_SIZE) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "{Max file size exceeded}"
                ).addConstraintViolation();
                result = false;
            }
        }

        return result;

    }

}
