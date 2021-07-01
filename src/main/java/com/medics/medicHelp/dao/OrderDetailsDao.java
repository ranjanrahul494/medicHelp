package com.medics.medicHelp.dao;

import com.medics.medicHelp.model.OrderDetails;

public interface OrderDetailsDao {
	
	public void addOrderDetails(OrderDetails orderDetails, String medicalStoreId);
	public OrderDetails getOrderDetails(String orderId);
	public void updateOrderDetails(OrderDetails orderDetails, String orderId);
}
