package jwtPractice.jwtPractice.DTOs;

import jwtPractice.jwtPractice.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private Role role;

}
