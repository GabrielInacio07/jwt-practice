package jwtPractice.jwtPractice.Controller;

import jwtPractice.jwtPractice.DTOs.UserDTO;
import jwtPractice.jwtPractice.Model.User;
import jwtPractice.jwtPractice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<Void> salvarUser(@RequestBody UserDTO dto){

        service.saveUser(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios(){

        return ResponseEntity.ok(service.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable UUID id){

        return ResponseEntity.ok(service.findUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuario(
            @PathVariable UUID id,
            @RequestBody UserDTO dto
    ){

        service.updateUser(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id){

        service.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}