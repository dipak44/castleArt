package com.castleArt.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	 public final String UPLOAD_DIR="C:\\Users\\dipak\\git\\castleArt\\CastleArt\\src\\main\\resources\\static\\";
	public FileUploadHelper()throws IOException
	{

	}

	public boolean uploadFile(MultipartFile multipartFile)
	{
		boolean status=false;

		try {

			Files.copy(multipartFile.getInputStream(),  Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING) ;
			status=true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


}



