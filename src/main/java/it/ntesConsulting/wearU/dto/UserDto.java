package it.ntesConsulting.wearU.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing a user in the system.
 * This class is used for transferring user-related data between layers, such as from the API to the client.
 * It contains the user's personal details and associated entities like orders and address.
 *
 * Annotations:
 * - `@Data`: Automatically generates getters, setters, `toString()`, `equals()`, and `hashCode()` methods.
 * - `@JsonInclude(JsonInclude.Include.NON_NULL)`: Ensures that only non-null fields are included in the serialized JSON.
 * - `@JsonIgnoreProperties(ignoreUnknown=true)`: Ignores unknown properties in the incoming JSON when deserializing, avoiding errors when extra fields are present.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    /**
     * Unique identifier for the user.
     * This is typically used to reference the user in the database or API.
     */
    private Long id;

    /**
     * Name of the user.
     * It could be the full name of the user (first and last name).
     */
    private String name;

    /**
     * Email address of the user.
     * This is the user's primary means of contact and often used for authentication.
     */
    private String email;

    /**
     * Password of the user.
     * This field is typically used for authentication purposes.
     */
    private String password;

    /**
     * Phone number of the user.
     * This field contains the user's contact phone number.
     */
    private String phoneNumber;

    /**
     * Role of the user within the system.
     * It specifies the user's role, such as "admin", "user", or "moderator".
     */
    private String role;

    /**
     * List of order items associated with the user.
     * This list contains all the order items that the user has placed, representing the user's purchases.
     */
    private List<OrderItemDto> oderItemList;

    /**
     * Address of the user.
     * This field holds the user's primary address information, typically used for shipping or billing purposes.
     */
    private AddressDto address;

}

