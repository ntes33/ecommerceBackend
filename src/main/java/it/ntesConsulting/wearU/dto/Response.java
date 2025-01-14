package it.ntesConsulting.wearU.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

/**
 * Represents the structure of a response returned by the API.
 * This class encapsulates the result of a request, including metadata
 * (such as status, message, token, pagination info) and related entity data
 * (such as user, category, product, and order information).
 * 
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	    private int status;
	    private String message;
	    private final LocalDateTime timestamp = LocalDateTime.now();

	    private String token;
	    private String role;
	    private String  expirationTime;

	    private int totalPage;
	    private long totalElement;

	    private AddressDto address;

	    private UserDto user;
	    private List<UserDto> userList;

	    private CategoryDto category;
	    private List<CategoryDto> categoryList;

	    private ProductDto product;
	    private List<ProductDto> productList;

	    private OrderItemDto orderItem;
	    private List<OrderItemDto> orderItemList;

	    private OrderDto order;
	    private List<OrderDto> orderList;

	

}

