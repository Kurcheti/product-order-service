package com.ecom.productorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productorder.entity.ProductOrder;
import com.ecom.productorder.service.ProductOrderService;

@RestController
@RequestMapping("/productOrder")
public class ProductOrderRestController {
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@PostMapping(path="/addOrder")
	public ResponseEntity<List<ProductOrder>> addOrder(@RequestBody List<ProductOrder> productOrderList){
		return new ResponseEntity<>(productOrderService.addOder(productOrderList),HttpStatus.OK);
	}
	
	@PutMapping(path="/updateOrder")
	public ResponseEntity<ProductOrder> updateOrder(@RequestBody ProductOrder productOrder){
		return new ResponseEntity<>(productOrderService.updateOder(productOrder),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/getOrdersByUserId/{userId}")
	public ResponseEntity<List<ProductOrder>> getOrdersByUserId(@PathVariable("userId") Integer userId){
		return new ResponseEntity<>(productOrderService.getProductOrdersByUserId(userId),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/getOrdersByOrderDateAndStatus/{orderDate}/{status}")
	public ResponseEntity<List<ProductOrder>> deleteUserById(@PathVariable("orderDate") String orderDate,@PathVariable("status") String status){
		return new ResponseEntity<>(productOrderService.getProuctOrderByOrderDateAndStatus(orderDate, status),HttpStatus.OK);
	}
	
}
