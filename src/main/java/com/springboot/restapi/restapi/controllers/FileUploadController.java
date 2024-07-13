package com.springboot.restapi.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.restapi.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

  @Autowired
  private FileUploadHelper fileUploadHelper;

  @PostMapping("/uploadfile")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    System.out.println(file.getContentType());
    System.out.println(file.getOriginalFilename());

    try {
      if (file.isEmpty()) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must contain a file");
      }

      boolean check = fileUploadHelper.fileUpload(file);
      if (check) {
        return ResponseEntity.ok("file uploaded successfully!");
      }

    } catch (Exception e) {
      System.err.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again later");
    }
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
