package com.castleArt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castleArt.dao.OrderRepository;
import com.castleArt.entities.Order;


@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	OrderRepository orderrepo;
	
	public int saveorder(Order order)
	{
		  int p=this.saveorder(order);
		  return p;
		
	}
}
