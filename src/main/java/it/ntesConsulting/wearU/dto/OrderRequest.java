package it.ntesConsulting.wearU.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.ntesConsulting.wearU.entity.Payment;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a request to create an order.
 * This class captures the total price, list of items, and payment information required to place an order.
 *
 * Annotations used:
 * - `@JsonIgnoreProperties(ignoreUnknown=true)` allows ignoring unknown properties during JSON deserialization.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class OrderRequest {

    /**
     * Total price of the order.
     * This field represents the overall price of the order, including all items and applicable taxes.
     */
    private BigDecimal totalPrice;

    /**
     * List of order items included in this order.
     * Each item contains product information and quantity.
     */
    private List<OrderItemRequest> items;

    /**
     * Payment information associated with this order.
     * This field contains the details of how the order will be paid for.
     */
    private Payment paymentInfo;

}

