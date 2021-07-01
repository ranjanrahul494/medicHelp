package com.medics.medicHelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medics.medicHelp.service.UserService;

@RestController
@RequestMapping("/uploadExcel")
public class UploadExcelController {
	@Autowired
	UserService userService;
	
	
	@PostMapping("/excelFile/{id}")
	public String readDadaFromExcel(@PathVariable String id,@RequestParam("multipartFile") MultipartFile multipartFile) {
		System.out.println("check excial upload file");
		userService.uploadExcelData(id,multipartFile);
		return "success";
		 
	}

}
