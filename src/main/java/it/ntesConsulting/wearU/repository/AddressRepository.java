package it.ntesConsulting.wearU.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ntesConsulting.wearU.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
