package com.medics.medicHelp.service;

import com.medics.medicHelp.model.OrderDetails;

public interface OrderDetailsService {
	
	public void addOrderDetails(OrderDetails orderDetails, String medicalStoreId);
	public void updateOrderDetails(OrderDetails orderDetails, String orderId) ;
}
