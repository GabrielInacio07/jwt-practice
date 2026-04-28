package jwtPractice.jwtPractice.DTOs;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonPropertyOrder({"code","message","details"})
@AllArgsConstructor
@Builder
@Getter
public class ErrorDTO {

    private int code;
    private String message;
    private String details;
}
