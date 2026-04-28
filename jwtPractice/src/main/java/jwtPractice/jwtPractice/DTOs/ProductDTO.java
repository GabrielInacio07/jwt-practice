package jwtPractice.jwtPractice.DTOs;

import lombok.*;

import java.util.UUID;

@Data
public class ProductDTO {

    private String title;
    private UUID userId;
}
