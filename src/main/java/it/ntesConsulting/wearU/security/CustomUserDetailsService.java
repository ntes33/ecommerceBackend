package it.ntesConsulting.wearU.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.ntesConsulting.wearU.entity.User;
import it.ntesConsulting.wearU.exception.NotFoundException;
import it.ntesConsulting.wearU.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
				.orElseThrow(() -> new NotFoundException("User/ Email not found"));

		return AuthUser.builder().user(user).build();
	}

}
