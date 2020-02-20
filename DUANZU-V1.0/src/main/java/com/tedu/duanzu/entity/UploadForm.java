package com.tedu.duanzu.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadForm {
	 private String description;
	 
	    private MultipartFile[] files;
}
