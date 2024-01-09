package com.nurserygarden.ecommerceapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


@RestController
@RequestMapping("/images")
public class ProductImageController {

    private final static Logger log = LoggerFactory.getLogger(ProductImageController.class);
    @Autowired
    private HttpServletRequest request;

    @PostMapping(path = "/products/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> saveImage(@RequestParam("image") @RequestPart MultipartFile document) throws Exception {
        if (!document.isEmpty()) {
            try {
                String dir = "/upload";
                String pathToUpload = request.getServletContext().getRealPath(dir);
                if (!new File(pathToUpload).exists()) {
                    new File(pathToUpload).mkdir();
                }
                log.info("Path of uploaded file = {}", pathToUpload);


                String orgName = document.getOriginalFilename();
                String filePath = pathToUpload + orgName;
                File dest = new File(filePath);
            } catch (Exception e) {
                log.error("Error: ", e);
            }
        }
            return ResponseEntity.ok("Successfully uploaded");
        }

}