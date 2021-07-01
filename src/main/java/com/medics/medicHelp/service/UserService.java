package com.medics.medicHelp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.medics.medicHelp.model.User;
import com.medics.medicHelp.model.UserAddress;

public interface UserService {
	void addUser(User user);
	User getUserDetails(String id);
	public void uploadFile(User user) throws IOException;
	void uploadExcelData(String id,MultipartFile multipartFile);
	void updateUserAddress(String id, UserAddress userAddress);
}
