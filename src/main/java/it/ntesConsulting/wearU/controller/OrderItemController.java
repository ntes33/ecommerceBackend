package it.ntesConsulting.wearU.controller;

import java.time.LocalDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.ntesConsulting.wearU.dto.OrderRequest;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.enums.OrderStatus;
import it.ntesConsulting.wearU.service.interfce.OrderItemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderItemController {

	private final OrderItemService orderItemService;
     //orderItemList
	@PostMapping("/create")
	public ResponseEntity<Response> placeOrder(@RequestBody OrderRequest orderRequest) {
		return ResponseEntity.ok(orderItemService.placeOrder(orderRequest));
	}

	@PutMapping("/update-item-status/{orderItemId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> updateOrderItemStatus(@PathVariable Long orderItemId, @RequestParam String status) {
		return ResponseEntity.ok(orderItemService.updateOrderItemStatus(orderItemId, status));
	}

	@GetMapping("/filter")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> filterOrderItems(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) Long itemId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1000") int size

	) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
		OrderStatus orderStatus = status != null ? OrderStatus.valueOf(status.toUpperCase()) : null;

		return ResponseEntity.ok(orderItemService.filterOrderItems(orderStatus, startDate, endDate, itemId, pageable));

	}

}
