 package it.ntesConsulting.wearU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.ntesConsulting.wearU.entity.OrderItem;


//dynamiq cearch
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>,JpaSpecificationExecutor<OrderItem> {

}



