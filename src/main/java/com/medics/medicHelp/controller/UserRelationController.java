package com.medics.medicHelp.controller;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medics.medicHelp.model.OrderDetails;
import com.medics.medicHelp.service.OrderDetailsService;
import com.medics.medicHelp.service.UserRelationService;

@RestController
@RequestMapping("/relation")
@CrossOrigin(origins="*")
public class UserRelationController {
	@Autowired
	UserRelationService userRelationService;
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	/* find which medicine store all medicine available */
	@GetMapping("/medicineStoreDetails/{userId}")
	public Set<String> getAvailableMedicalStore(@PathVariable("userId") String userId) throws IOException {
		Set<String> medicalStoreName=userRelationService.getMedicineStoreDetails(userId);
		return medicalStoreName;
	}
	
	/* add order and store order details in orderDetails table */
	@PostMapping("/order/{medicalStoreId}")
	public void addOrderDetails(@RequestBody OrderDetails orderDetails,@PathVariable("medicalStoreId") String medicalStoreId) {
		orderDetailsService.addOrderDetails(orderDetails, medicalStoreId);		 
	}
	
	/* get all medicine details which one user going to order */
	@GetMapping("/medicineDetails/{orderId}")
	public OrderDetails getOrderDetails(@PathVariable("orderId") String orderId) {
		OrderDetails orderDetails=userRelationService.getOrderDetails(orderId);
		return orderDetails;
	}
}
