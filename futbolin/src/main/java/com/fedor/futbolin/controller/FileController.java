package com.fedor.futbolin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fedor.futbolin.service.IFileService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
@RequestMapping(path = "/api/v1/files", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileController {
	
	@Autowired
	private IFileService fileService;

	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) {
		return fileService.saveFile(file, httpServletRequest);
	}
}
