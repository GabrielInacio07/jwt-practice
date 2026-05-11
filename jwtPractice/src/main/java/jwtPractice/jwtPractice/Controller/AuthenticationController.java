package jwtPractice.jwtPractice.Controller;

import jwtPractice.jwtPractice.DTOs.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager manager;


    @PostMapping
    public ResponseEntity<Void> login(@RequestBody AuthDTO dto){

        var token = new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
