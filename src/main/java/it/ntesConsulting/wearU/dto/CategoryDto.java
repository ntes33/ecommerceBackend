package it.ntesConsulting.wearU.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing a product category.
 * This class is used to transfer category data between different application layers.
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
public class CategoryDto {

    private Long id;

    private String name;

    private List<ProductDto> productList;

}

