package com.medics.medicHelp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medics.medicHelp.dao.UserDao;
import com.medics.medicHelp.model.User;
import com.medics.medicHelp.model.UserAddress;
@Service
public class UserServiceImp implements UserService{
@Autowired
private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}
	@Override
	public User getUserDetails(String id) {
		return userDao.getUserDetails(id);
	}
	@Override
	public void uploadFile(User user) throws IOException {
		userDao.uploadFile(user);
		
	}
	@Override
	public void uploadExcelData(String id,MultipartFile multipartFile) {
		userDao.uploadExcelData(id,multipartFile);
		
	}
	@Override
	public void updateUserAddress(String id, UserAddress userAddress) {
		userDao.updateUserAddress(id,userAddress);
		
	}

}
