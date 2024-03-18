package com.ecom.productorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.productorder.entity.ProductOrder;
@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer>{
	public List<ProductOrder> findByUserId(Integer userId);
	
	public List<ProductOrder> findByOrderDateAndOrderStatus(String orderDate,String orderStatus);

}
