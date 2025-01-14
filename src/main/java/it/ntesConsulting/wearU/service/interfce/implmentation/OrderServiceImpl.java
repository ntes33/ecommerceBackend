package it.ntesConsulting.wearU.service.interfce.implmentation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import it.ntesConsulting.wearU.dto.OrderItemDto;
import it.ntesConsulting.wearU.dto.OrderRequest;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.entity.Order;
import it.ntesConsulting.wearU.entity.OrderItem;
import it.ntesConsulting.wearU.entity.Product;
import it.ntesConsulting.wearU.entity.User;
import it.ntesConsulting.wearU.enums.OrderStatus;
import it.ntesConsulting.wearU.exception.NotFoundException;
import it.ntesConsulting.wearU.mapper.EntityDtoMapper;
import it.ntesConsulting.wearU.repository.OrderItemRepository;
import it.ntesConsulting.wearU.repository.OrderRepository;
import it.ntesConsulting.wearU.repository.ProductRepository;
import it.ntesConsulting.wearU.service.interfce.OrderItemService;
import it.ntesConsulting.wearU.service.interfce.UserService;
import it.ntesConsulting.wearU.specification.OrderItemSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderItemService {

	    private final OrderRepository orderRepository;
	    private final OrderItemRepository orderItemRepository;
	    private final ProductRepository productRepository;
	    private final UserService userService;
	    private final EntityDtoMapper entityDtoMapper;  
	
	    @Override
	    public Response placeOrder(OrderRequest orderRequest) {

	        User user = userService.getLoginUser();
	        //map order request items to order entities

	        List<OrderItem> orderItems = orderRequest.getItems().stream().map(orderItemRequest -> {
	            Product product = productRepository.findById(orderItemRequest.getProductId())
	                    .orElseThrow(()-> new NotFoundException("Product Not Found"));

	            OrderItem orderItem = new OrderItem();
	            orderItem.setProduct(product);
	            orderItem.setQuantity(orderItemRequest.getQuantity());
	            orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()))); //set price according to the quantity
	            orderItem.setStatus(OrderStatus.PENDING);
	            orderItem.setUser(user);
	            return orderItem;

	        }).collect(Collectors.toList());

	        //calculate the total price
	        BigDecimal totalPrice = orderRequest.getTotalPrice() != null && orderRequest.getTotalPrice().compareTo(BigDecimal.ZERO) > 0
	                ? orderRequest.getTotalPrice()
	                : orderItems.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

	        //create order entity
	        Order order = new Order();
	        order.setOrderItemList(orderItems);
	        order.setTotalPrice(totalPrice);

	        //set the order reference in each orderitem
	        orderItems.forEach(orderItem -> orderItem.setOrder(order));

	        orderRepository.save(order);

	        return Response.builder()
	                .status(200)
	                .message("Order was successfully placed")
	                .build();

	    }

	    @Override
	    public Response updateOrderItemStatus(Long orderItemId, String status) {
	        OrderItem orderItem = orderItemRepository.findById(orderItemId)
	                .orElseThrow(()-> new NotFoundException("Order Item not found"));

	        orderItem.setStatus(OrderStatus.valueOf(status.toUpperCase()));
	        orderItemRepository.save(orderItem);
	        return Response.builder()
	                .status(200)
	                .message("Order status updated successfully")
	                .build();
	    }

	    @Override
	    public Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable) {
	        Specification<OrderItem> spec = Specification.where(OrderItemSpecification.hasStatus(status))
	                .and(OrderItemSpecification.createdBetween(startDate, endDate))
	                .and(OrderItemSpecification.hasItemId(itemId));

	        Page<OrderItem> orderItemPage = orderItemRepository.findAll(spec, pageable);

	        if (orderItemPage.isEmpty()){
	            throw new NotFoundException("No Order Found");
	        }
	        List<OrderItemDto> orderItemDtos = orderItemPage.getContent().stream()
	                .map(entityDtoMapper::mapOrderItemToDtoPlusProductAndUser)
	                .collect(Collectors.toList());

	        return Response.builder()
	                .status(200)
	                .orderItemList(orderItemDtos)
	                .totalPage(orderItemPage.getTotalPages())
	                .totalElement(orderItemPage.getTotalElements())
	                .build();
	    }
	
}
