package it.ntesConsulting.wearU.entity;

import java.util.List;

import org.joda.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="categories")
public class Category {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
	    @Column(unique=true)
	    private String name;
	    
	    @OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	    private List<Product>productList;
	    

	    @Column(name="created_at")
		private final LocalDateTime createdAt=LocalDateTime.now();
	    
	    
	    
	
}
