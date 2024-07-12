package kr.co.polycube.backendtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.polycube.backendtest.Controller.UserController;
import kr.co.polycube.backendtest.Dto.UserDto;
import kr.co.polycube.backendtest.Entity.User;
import kr.co.polycube.backendtest.Repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserTest {
    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    User user = User.builder()
            .name("testName1")
            .build();

    @Test
    @DisplayName("User Create Test")

    public void createUserTest() throws Exception {
        UserDto userDto = UserDto.builder().name("Test Name 1").build();

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Test Name 1"));
    }

    @Test
    @DisplayName("User Update Test")
    public void updateUserTest() throws Exception {
        User user = User.builder().build();
        user.updateUser("John Doe");
        user = userRepository.save(user);

        UserDto userDto = UserDto.builder().name("Changed Name 1").build();

        mockMvc.perform(put("/users/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value("Changed Name 1"));
    }

    @Test
    @DisplayName("User Get Test")
    public void getUserTest() throws Exception {
        User user = User.builder()
                .name("Test Name 2")
                .build();
        user = userRepository.save(user);

        mockMvc.perform(get("/users/" + user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value("Test Name 2"));
    }



}
