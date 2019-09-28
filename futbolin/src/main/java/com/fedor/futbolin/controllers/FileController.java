package com.fedor.futbolin.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fedor.futbolin.service.IFileService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "/file")
public class FileController {
	
	@Autowired
	private IFileService fileService;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpSession session) {
		return fileService.saveFile(file, session);
	}
}
