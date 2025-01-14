package it.ntesConsulting.wearU.entity;

import org.joda.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="adresses")
public class Address {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	    
	    private String street;
	    private String city;
	    private String state;
	    private String zipCode;
	    private String country;
	    
	    @ManyToOne( fetch= FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    @Column(name="created_at")
		private final LocalDateTime createdAt=LocalDateTime.now();
	
	
	
}
