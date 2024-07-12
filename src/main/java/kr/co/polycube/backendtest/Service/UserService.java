package kr.co.polycube.backendtest.Service;

import kr.co.polycube.backendtest.Dto.UserDto;
import kr.co.polycube.backendtest.Entity.User;
import kr.co.polycube.backendtest.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public UserDto createUser(UserDto userDto){
        if (userDto.getName() == null || userDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Name은 공백일 수 없습니다.");
        }
        User user = User.builder()
                .name(userDto.getName())
                .build();

            user = userRepository.save(user);

        return UserDto.builder()
                    .id(user.getId())
                    .build();
    }

    @Transactional
    public UserDto getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("User가 존재하지 않습니다."));

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public UserDto updateUser(Long id, UserDto userDto){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("User가 존재하지 않습니다."));

        if (userDto.getName() == null || userDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Name은 공백일 수 없습니다.");
        }
        user.updateUser(userDto.getName());
        userRepository.save(user);

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException runtimeException){
        Map<String, String> response = new HashMap<>();
        response.put("User가 존재하지 않습니다.", runtimeException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
