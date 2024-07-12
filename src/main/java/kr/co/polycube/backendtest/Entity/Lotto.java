package kr.co.polycube.backendtest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lotto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number_1;
    private int number_2;
    private int number_3;
    private int number_4;
    private int number_5;
    private int number_6;

    @Builder Lotto(Long id, int number_1, int number_2, int number_3, int number_4, int number_5, int number_6){
        this.id = id;
        this.number_1 = number_1;
        this.number_2 = number_2;
        this.number_3 = number_3;
        this.number_4 = number_4;
        this.number_5 = number_5;
        this.number_6 = number_6;
    }
}
