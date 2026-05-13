package jwtPractice.jwtPractice.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        var login = tokenService.validateToken(tokenJWT);
        System.out.println(login);

        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request) {

        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader == null){
            throw new RuntimeException("Token null");
        }

        return authorizationHeader.replace("Bearer","");
    }
}
