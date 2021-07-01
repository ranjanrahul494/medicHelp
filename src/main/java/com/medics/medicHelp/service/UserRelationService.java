package com.medics.medicHelp.service;

import java.util.Set;

import com.medics.medicHelp.model.OrderDetails;

public interface UserRelationService {
	public Set<String> getMedicineStoreDetails(String userId);
	public OrderDetails getOrderDetails(String orderId);
}
