package com.medics.medicHelp.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.medics.medicHelp.exception.DuplicateId;
import com.medics.medicHelp.model.Medicine;
import com.medics.medicHelp.model.User;
import com.medics.medicHelp.model.UserAddress;

@Repository
public class UserDaoImp implements UserDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public final static String collection_name="user";
	
	/*....... add new user in user collection ......*/
	@Override
	public void addUser(User user) {
		if(!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
		try {
			mongoTemplate.insert(user,collection_name);
		} catch (Exception e) {
			throw new DuplicateId("user allready exist");
		}		
		
	}
	
	/*....... get user details ......*/
	@Override
	public User getUserDetails(String id) {
		User userDetails=null;
		
			userDetails=mongoTemplate.findById(id, User.class);
				return userDetails;
	}

	@Override
	public void uploadFile(User user) throws IOException {
		mongoTemplate.save(user);
		
	}

	@Override
	public void uploadExcelData(String id,MultipartFile multipartFile) {
		Workbook workbook=getWorkBookFile(multipartFile);
		Sheet sheet=workbook.getSheetAt(0);
		Iterator<Row> rows=sheet.iterator();
		User userDetails = this.getUserDetails(id);
		List<Medicine> medicines=new ArrayList<Medicine>();
		while(rows.hasNext()) {
			Row row=rows.next();
			if(row.getCell(1).getCellType()==Cell.CELL_TYPE_STRING) {
				//medicines.add(new MedicineList(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue()));
			}else {
				medicines.add(new Medicine(row.getCell(0).getStringCellValue(),(int) row.getCell(1).getNumericCellValue()));
			}
			
			
		}
		userDetails.setMedicine(medicines);
		try {
			this.uploadFile(userDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private Workbook getWorkBookFile(MultipartFile multipartFile) {
		Workbook workbook=null;
		try {
			workbook=new XSSFWorkbook(multipartFile.getInputStream());
			//workbook=new HSSFWorkbook(multipartFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	@Override
	public void updateUserAddress(String id, UserAddress userAddress) {
		User userDetails = this.getUserDetails(id);
		List<UserAddress> userAddressesList=new ArrayList<UserAddress>();
		userAddressesList.add(new UserAddress(userAddress.getAddress(), userAddress.getCity(), userAddress.getState(), userAddress.getZipCode()));
		userDetails.setAddress(userAddressesList);
		try {
			this.uploadFile(userDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
