package com.springboot.restapi.restapi.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

  public final String UPLOAD_DIR = "D:\\spring boot\\Rest API in visualStudio\\restapi\\src\\main\\resources\\static\\image";

  public boolean fileUpload(MultipartFile file) {

    boolean f = false;

    try {
      InputStream is = file.getInputStream();
      byte data[] = new byte[is.available()];
      is.read(data);

      try (FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename())) {
        fos.write(data);
        fos.close();
      }
      f = true;

    } catch (IOException e) {
      System.out.println(e);
    }

    return f;
  }
}
