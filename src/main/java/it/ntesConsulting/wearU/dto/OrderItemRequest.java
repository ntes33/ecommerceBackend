package it.ntesConsulting.wearU.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a request to add an item to an order.
 * This class captures the product ID and quantity needed to create an order item.
 */
@Data
public class OrderItemRequest {

    /**
     * Unique identifier for the product being ordered.
     */
    private Long productId;

    /**
     * Quantity of the product to be added to the order.
     */
    private int quantity;

}

