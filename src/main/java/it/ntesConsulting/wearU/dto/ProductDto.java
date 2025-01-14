package it.ntesConsulting.wearU.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing a product.
 * This class is used to transfer product data between different application layers.
 *
 * Annotations used:
 * - `@Data` from Lombok to automatically generate getter, setter, equals, and hashCode methods.
 * - `@JsonInclude(JsonInclude.Include.NON_NULL)` ensures that fields with null values are not serialized in JSON.
 * - `@JsonIgnoreProperties(ignoreUnknown=true)` allows ignoring unknown properties during JSON deserialization.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    /**
     * Unique identifier for the product.
     */
    private Long id;

    /**
     * Name of the product.
     */
    private String name;

    /**
     * Description of the product.
     */
    private String description;

    /**
     * URL of the product image.
     */
    private String imageUrl;

    /**
     * Price of the product.
     */
    private BigDecimal price;

    /**
     * Category of the product.
     */
    private CategoryDto category;

}

