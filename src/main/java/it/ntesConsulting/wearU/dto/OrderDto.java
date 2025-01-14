package it.ntesConsulting.wearU.dto;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing an order.
 * This class is used to transfer order data between different application layers.
 *
 * Annotations used:
 * - `@Data` from Lombok to automatically generate getter, setter, equals, and hashCode methods.
 * - `@JsonInclude(JsonInclude.Include.NON_NULL)` ensures null fields are not serialized in JSON.
 * - `@JsonIgnoreProperties(ignoreUnknown=true)` allows ignoring unknown properties during JSON deserialization.
 * - `@AllArgsConstructor` from Lombok to generate a constructor with all fields.
 * - `@NoArgsConstructor` from Lombok to generate a no-argument constructor.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    /**
     * Unique identifier for the order.
     */
    private Long id;

    /**
     * Total price of the order.
     */
    private BigDecimal totalPrice;

    /**
     * Date and time when the order was created.
     */
    private LocalDateTime createdAt;

    /**
     * List of order items associated with this order.
     */
    private List<OrderItemDto> orderItemList;
    
}

