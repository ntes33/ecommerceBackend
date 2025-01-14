package it.ntesConsulting.wearU.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.service.interfce.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	 private final UserService userService;


	 @GetMapping("/get-all")
	 @PreAuthorize("hasAuthority('ADMIN')")
	 public ResponseEntity<Response> getAllUsers(){
	        return ResponseEntity.ok(userService.getAllUsers());
	    }

	 @GetMapping("/my-info")
	 public ResponseEntity<Response> getUserInfoAndOrderHistory(){
	        return ResponseEntity.ok(userService.getUserInfoAndOrderHistory());
	    }
	
	
	
}
