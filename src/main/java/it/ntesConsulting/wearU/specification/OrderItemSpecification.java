package it.ntesConsulting.wearU.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import it.ntesConsulting.wearU.entity.OrderItem;
import it.ntesConsulting.wearU.enums.OrderStatus;

public class OrderItemSpecification {
	//search by status
  public static Specification<OrderItem> hasStatus(OrderStatus  status){
	  
	  return((root,query,criteriaBuilder)->
	        status != null ? criteriaBuilder.equal(root.get("status"),status):null);
	
  }
//search by interval time
 public static Specification<OrderItem> createdBetween(LocalDateTime startDate, LocalDateTime endDate ){
	  
	  return((root,query,criteriaBuilder)->{
		  if (startDate != null && endDate != null) {
			  return criteriaBuilder.between(root.get("createdAt"),startDate,endDate);
		  }else if(startDate !=null ) {
			  return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt" ),startDate);
		  }else if (endDate !=null) {
			  return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"),endDate);
		  }else {
			  
			  return null;
		  }
		  
	  });

  }
  
  public static Specification<OrderItem>hasItemId(Long itemId){
	  return((root,query,criteriaBuilder)->
	  itemId != null ? criteriaBuilder.equal(root.get("id"),itemId):null);
	  
  }
  
}
