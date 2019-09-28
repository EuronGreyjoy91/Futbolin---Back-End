package com.fedor.futbolin.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	String saveFile(MultipartFile file, HttpSession session);
}
