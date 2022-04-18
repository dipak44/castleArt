package com.castleArt.service;

import org.springframework.stereotype.Service;

import com.castleArt.entities.Order;

@Service
public interface IOrderService {
	
	public int saveorder(Order order);

}
