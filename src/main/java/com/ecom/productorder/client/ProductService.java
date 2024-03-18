package com.ecom.productorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE/products")
public interface ProductService {
	@PutMapping(path="/decreaseProductQuantity/{productId}")
	public ResponseEntity<String> decreaseProductQuantity(@PathVariable("productId") Integer productId, @RequestParam("quantity") Integer quantity);

}
