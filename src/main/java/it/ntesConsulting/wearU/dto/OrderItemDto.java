package it.ntesConsulting.wearU.dto;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing an item in an order.
 * This class is used to transfer order item data between different application layers.
 *
 * Annotations used:
 * - `@Data` from Lombok to automatically generate getter, setter, equals, and hashCode methods.
 * - `@JsonInclude(JsonInclude.Include.NON_NULL)` ensures null fields are not serialized in JSON.
 * - `@JsonIgnoreProperties(ignoreUnknown=true)` allows ignoring unknown properties during JSON deserialization.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    /**
     * Unique identifier for the order item.
     */
    private Long id;

    /**
     * Quantity of the product in this order item.
     */
    private int quantity;

    /**
     * Price of the product in this order item.
     */
    private BigDecimal price;

    /**
     * Status of the order item.
     */
    private String status;

    /**
     * User associated with this order item.
     */
    private UserDto user;

    /**
     * Product associated with this order item.
     */
    private ProductDto product;

    /**
     * Date and time when the order item was created.
     */
    private LocalDateTime createdAt;

}

