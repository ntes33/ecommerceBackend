package it.ntesConsulting.wearU.service.interfce.implmentation;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.ntesConsulting.wearU.dto.LoginRequest;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.dto.UserDto;
import it.ntesConsulting.wearU.entity.User;
import it.ntesConsulting.wearU.enums.UserRole;
import it.ntesConsulting.wearU.exception.InvalidCredentialsException;
import it.ntesConsulting.wearU.exception.NotFoundException;
import it.ntesConsulting.wearU.mapper.EntityDtoMapper;
import it.ntesConsulting.wearU.repository.UserRepository;
import it.ntesConsulting.wearU.security.JwtUtils;
import it.ntesConsulting.wearU.service.interfce.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtils jwtUtils;
	private final EntityDtoMapper entityDtoMapper;

	@Override
	public Response registerUser(UserDto registrationRequest) {
		UserRole role = UserRole.USER;
        
		if (registrationRequest.getRole() != null && registrationRequest.getRole().equalsIgnoreCase("admin")) {
			role = UserRole.ADMIN;
		}

		User user = User.builder().name(registrationRequest.getName()).email(registrationRequest.getEmail())
				.password(passwordEncoder.encode(registrationRequest.getPassword()))
				.phoneNumber(registrationRequest.getPhoneNumber()).role(role).build();
       
		User savedUser = userRepository.save(user);
		System.out.println(savedUser);
        
		UserDto userDto = entityDtoMapper.mapUserToDtoBasic(savedUser);
		return Response.builder().status(200).message("User Successfully Added").user(userDto).build();
	}

	@Override
	public Response loginUser(LoginRequest loginRequest) {
        //control user info
		User user = userRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new NotFoundException("Email not found"));
		if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			throw new InvalidCredentialsException("Password does not match");
		}
		String token = jwtUtils.generateToken(user);

		return Response.builder().status(200).message("User Successfully Logged In").token(token)
				.expirationTime("6 Month").role(user.getRole().name()).build();
	}

	@Override
	public Response getAllUsers() {

		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(entityDtoMapper::mapUserToDtoBasic).toList();

		return Response.builder().status(200).userList(userDtos).build();
	}
     //get login user using SecurityContextHolder interface 
	@Override
	public User getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		log.info("User Email is: " + email);
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
	}

	@Override
	public Response getUserInfoAndOrderHistory() {
		User user = getLoginUser();
		UserDto userDto = entityDtoMapper.mapUserToDtoPlusAddressAndOrderHistory(user);

		return Response.builder().status(200).user(userDto).build();
	}

}
