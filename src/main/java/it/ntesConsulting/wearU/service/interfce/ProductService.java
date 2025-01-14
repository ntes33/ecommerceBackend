package it.ntesConsulting.wearU.service.interfce;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import it.ntesConsulting.wearU.dto.Response;

public interface ProductService {

	    Response createProduct(Long categoryId, MultipartFile image, String name, String description, BigDecimal price);
	    Response updateProduct(Long productId, Long categoryId, MultipartFile image, String name, String description, BigDecimal price);
	    Response deleteProduct(Long productId);
	    Response getProductById(Long productId);
	    Response getAllProducts();
	    Response getProductsByCategory(Long categoryId);
	    Response searchProduct(String searchValue);
	
}
