package com.ecom.productorder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="PRODUCT_ORDER")
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_order_id")
	private Integer productOrderId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "order_date")
	private String orderDate;

}
