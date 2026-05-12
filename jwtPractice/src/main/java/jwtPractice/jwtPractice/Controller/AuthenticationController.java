package jwtPractice.jwtPractice.Controller;

import jwtPractice.jwtPractice.DTOs.AuthDTO;
import jwtPractice.jwtPractice.DTOs.jwtDTO;
import jwtPractice.jwtPractice.Model.User;
import jwtPractice.jwtPractice.Security.TokenService;
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

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<jwtDTO> login(@RequestBody AuthDTO dto){

        var token = new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword());
        var authentication = manager.authenticate(token);
        var jwt = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new jwtDTO(jwt));
    }
}
