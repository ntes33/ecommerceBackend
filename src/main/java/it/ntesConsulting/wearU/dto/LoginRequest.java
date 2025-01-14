package it.ntesConsulting.wearU.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a login request.
 * This class is used to capture the email and password fields for user authentication.
 *
 * Annotations used:
 * - `@Data` from Lombok to automatically generate getter, setter, equals, and hashCode methods.
 * - `@NotBlank` from Jakarta Validation to ensure that both email and password are not blank.
 */
@Data
public class LoginRequest {

    /**
     * Email address for the login request.
     * This field is required and cannot be blank.
     */
    @NotBlank(message = "Email is required")
    private String email;

    /**
     * Password for the login request.
     * This field is required and cannot be blank.
     */
    @NotBlank(message = "Password is required")
    private String password;

}

