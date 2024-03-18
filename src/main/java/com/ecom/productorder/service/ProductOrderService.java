package com.ecom.productorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.productorder.client.ProductService;
import com.ecom.productorder.entity.ProductOrder;
import com.ecom.productorder.repository.ProductOrderRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductOrderService {
	
	@Autowired
	private ProductOrderRepo productOrderRepo;
	@Autowired
	private ProductService productService;
	
	public List<ProductOrder> addOder(List<ProductOrder> productOrders){
		
	for (ProductOrder productOrder : productOrders) {
		log.info(productOrder.getProductId() +"updatation started");
	    productService.decreaseProductQuantity(productOrder.getProductId(), productOrder.getQuantity())	;
	    log.info(productOrder.getProductId() +"updated");
	}
	 return productOrderRepo.saveAll(productOrders);
	}
	
	public ProductOrder updateOder(ProductOrder productOrder){
		productOrderRepo.findById(productOrder.getProductId()).orElseThrow(
				()->new RuntimeException("Product Order not found with "+productOrder.getProductOrderId()));
		return productOrderRepo.save(productOrder);
	}
	
	public List<ProductOrder> getProductOrdersByUserId(Integer userId){
		return productOrderRepo.findByUserId(userId);
	}
	
	public List<ProductOrder> getProuctOrderByOrderDateAndStatus(String orderDate,String status){
		return productOrderRepo.findByOrderDateAndOrderStatus(orderDate, status);
	}
	
	public List<ProductOrder> getAllProductOrders(){
		return productOrderRepo.findAll();
	}
	
}
