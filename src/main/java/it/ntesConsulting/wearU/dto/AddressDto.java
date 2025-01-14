package it.ntesConsulting.wearU.dto;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing an address.
 * This class is used to transfer address data between different application layers.
 */

/**
 * Data Transfer Object (DTO) representing an address.
 * This class is used to transfer address data between different application layers.
 *
 * Annotations used:
 * - `@Data` from Lombok to generate getter, setter, equals, and hashCode methods automatically.
 * - `@JsonInclude(JsonInclude.Include.NON_NULL)` ensures null fields are not serialized in JSON.
 * - `@JsonIgnoreProperties(ignoreUnknown=true)` allows ignoring unknown properties during JSON deserialization.
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    /**
     * Unique identifier for the address.
     */
    private Long id;

    /**
     * Street address.
     */
    private String street;

    /**
     * City of the address.
     */
    private String city;

    /**
     * State or province of the address.
     */
    private String state;

    /**
     * Postal or ZIP code of the address.
     */
    private String zipCode;

    /**
     * Country of the address.
     */
    private String country;

    /**
     * User associated with this address.
     */
    private UserDto user;

    /**
     * Date and time when the address was created.
     */
    private LocalDateTime createdAt;
}

