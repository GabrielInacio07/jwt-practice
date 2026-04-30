package jwtPractice.jwtPractice.Service;

import jwtPractice.jwtPractice.Exception.UserNotFound;
import jwtPractice.jwtPractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email){
        return (UserDetails) repository.findByEmail(email)
                .orElseThrow( () -> new UserNotFound("Usuário não encontrado"));
    }
}
