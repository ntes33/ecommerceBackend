package it.ntesConsulting.wearU.service.interfce;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;

import it.ntesConsulting.wearU.dto.OrderRequest;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.enums.OrderStatus;

public interface OrderItemService {
	    Response placeOrder(OrderRequest orderRequest);
	    Response updateOrderItemStatus(Long orderItemId, String status);
	    //Pageable
	    Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable);
}
