package com.simbirsoft.taxi_service.service.security;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> candidate = userRepository.findByEmail(email);
        if (!candidate.isPresent()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return candidate.get();
    }
}
