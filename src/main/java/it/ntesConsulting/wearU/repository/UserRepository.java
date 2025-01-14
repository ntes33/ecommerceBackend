package it.ntesConsulting.wearU.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ntesConsulting.wearU.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByEmail(String email);
	
	
}