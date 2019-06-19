package com.simbirsoft.taxi_service.services.security;

import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> candidate = userRepository.findByEmail(email);
        if (!candidate.isPresent()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return candidate.get();
    }
}
