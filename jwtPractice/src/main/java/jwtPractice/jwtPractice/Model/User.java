package jwtPractice.jwtPractice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
