package com.fedor.futbolin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements IFileService{

	@Override
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		
		String fileName = new Date().getTime() + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
		String path = request.getServletContext().getRealPath("") + "/files/" + fileName;
	       
        try{  
        	InputStream inputStream = file.getInputStream();
        	OutputStream outputStream = new FileOutputStream(new File(path));
        	int read = 0;
        	byte[] bytes = new byte[1024];
        	while( (read = inputStream.read(bytes)) != -1) {
        		outputStream.write(bytes, 0, read);
        	}
        	
        	outputStream.flush();
        	outputStream.close();
            
        	
        	
            return fileName;

        }  
        catch(Exception exception){  
            System.out.println("Error al subir la imagen:: " + exception.getMessage());  
            return null;
        }
        
	}
}

