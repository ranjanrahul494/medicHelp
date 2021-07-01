package com.medics.medicHelp.controller;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medics.medicHelp.model.User;
import com.medics.medicHelp.service.UserService;

@RestController
@RequestMapping("/file")
public class UploadPrescriptionController {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	UserService userService;
	
	@PostMapping("/upload/{id}")
	public String fileUpload(@PathVariable String id,@RequestParam("file") MultipartFile multipart) throws IOException {
		System.out.println(">>>>>>>>>>>>>...........check..............<<<<<<<<<<<<<<<<<<<<");
		User userDetails = userService.getUserDetails(id);
		userDetails.setImage(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
		userService.uploadFile(userDetails);
		return "success";
	}
	
}
