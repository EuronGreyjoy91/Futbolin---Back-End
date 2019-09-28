package com.fedor.futbolin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements IFileService{

	@Override
	public String saveFile(MultipartFile file, HttpSession session) {
		
	    String nameExtension[] = file.getContentType().split("/");  
	    String profileImage = new Date().getTime() + "." + nameExtension[1];  
	       
        try{  
        	File convFile = new File("src/main/resources/images/"+profileImage);
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);

            fos.write(file.getBytes());
            fos.close();
            System.out.println(convFile.getName());
            
            return profileImage;

        }  
        catch(Exception exception){  
            System.out.println("error while uploading image catch:: " + exception.getMessage());  
            return null;
        }
        
	}
}

