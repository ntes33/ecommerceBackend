package it.ntesConsulting.wearU.entity;

import java.math.BigDecimal;

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
@Table(name="products")
public class Product {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Long id;
	 
	   private String name;
	   private String description;
	   private String imageUrl;
	   
	   // BigDecimal is ideal for monetary fields in Java due to its precision, 
	   //scale control, and ability to handle large values accurately
	    
	   private BigDecimal price;
	   /*@ManyToOne(fetch = FetchType.LAZY)  The associated entity is loaded only when 
	    * explicitly accessed.
        * @ManyToOne(fetch = FetchType.EAGER) The associated entity is loaded immediately 
        * with the main entity.
	    * 
	    */
	   @ManyToOne(fetch= FetchType.LAZY)
	   @JoinColumn(name="category_id")
	   private Category  category;
	   
	   @Column(name="created_at")
	   private final LocalDateTime createdAt=LocalDateTime.now();
	    
	    
	   
	   
	   
	
}
