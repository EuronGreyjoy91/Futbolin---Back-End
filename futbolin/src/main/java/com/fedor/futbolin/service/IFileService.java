package com.fedor.futbolin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	String saveFile(MultipartFile file, HttpServletRequest request);
}
