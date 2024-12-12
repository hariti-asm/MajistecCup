package ma.hariti.asmaa.wrm.majesticcup.service.impl;

import ma.hariti.asmaa.wrm.majesticcup.entity.User;
import ma.hariti.asmaa.wrm.majesticcup.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
     private final UserRepository userRepository;
public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        switch(user.getRole()) {
            case ADMIN:
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            case OPERATOR:
                authorities.add(new SimpleGrantedAuthority("ROLE_OPERATOR"));
                break;
            default:
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}