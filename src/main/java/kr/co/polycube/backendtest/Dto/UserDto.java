package kr.co.polycube.backendtest.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
public class UserDto {
    private Long id;

    private String name;

   @Builder
    public UserDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}

