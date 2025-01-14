package it.ntesConsulting.wearU.entity;

import java.util.List;

import org.joda.time.LocalDateTime;

import it.ntesConsulting.wearU.enums.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// to generate getter and setter lombock
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "name is required")
	private String name;

	@Column(unique = true)
	@NotBlank(message = "email is required")
	private String email;

	@NotBlank(message = "password is required")
	private String password;

	@Column(name = "phone_number")
	@NotBlank(message = "phone number is required")
	private String phoneNumber;
	private UserRole role;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> orderItemList;
    /*
     * cascade = CascadeType.ALL
     * Any change to a category (creation, update, deletion) 
     * will be cascaded to the associated products.
     */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;

	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();

}
