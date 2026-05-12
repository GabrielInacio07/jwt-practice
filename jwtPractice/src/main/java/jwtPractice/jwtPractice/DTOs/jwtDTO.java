package jwtPractice.jwtPractice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class jwtDTO {

    private String token;
}
