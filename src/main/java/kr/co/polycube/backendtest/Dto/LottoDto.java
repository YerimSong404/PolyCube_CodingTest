package kr.co.polycube.backendtest.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LottoDto {
    private int number_1;
    private int number_2;
    private int number_3;
    private int number_4;
    private int number_5;
    private int number_6;

    @Builder LottoDto(Long id, int number_1, int number_2, int number_3, int number_4, int number_5, int number_6){
        this.number_1 = number_1;
        this.number_2 = number_2;
        this.number_3 = number_3;
        this.number_4 = number_4;
        this.number_5 = number_5;
        this.number_6 = number_6;
    }
}
