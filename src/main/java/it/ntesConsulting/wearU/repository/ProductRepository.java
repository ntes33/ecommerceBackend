package it.ntesConsulting.wearU.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import it.ntesConsulting.wearU.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {
	
	List<Product> findByCategoryId(Long categoryId);
	List<Product> findByNameOrDescription(String name,String description);
	 
	// List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
	
}



