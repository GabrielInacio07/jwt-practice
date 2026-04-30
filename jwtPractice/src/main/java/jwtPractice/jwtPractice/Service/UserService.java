package jwtPractice.jwtPractice.Service;

import jwtPractice.jwtPractice.DTOs.UserDTO;
import jwtPractice.jwtPractice.Exception.UserNotFound;
import jwtPractice.jwtPractice.Model.User;
import jwtPractice.jwtPractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private void validateInput(UserDTO dto){

        if(dto.getName().isBlank() || dto.getEmail().isBlank() || dto.getPassword().isBlank()){
            throw new IllegalArgumentException("Nenhum campo pode estar vazio");
        }
    }

    public void saveUser(UserDTO dto){

        validateInput(dto);

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();

        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(UUID id){

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
    }

    public User findyByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow( () -> new UserNotFound("Usuário não encontrado"));
    }

    public void updateUser(UUID id, UserDTO dto){

        validateInput(dto);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("Usuário não encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
    }

    public void deleteUser(UUID id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound("Usuário não encontrado"));

        userRepository.delete(user);
    }
}