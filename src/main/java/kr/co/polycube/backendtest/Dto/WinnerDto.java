package kr.co.polycube.backendtest.Dto;

import kr.co.polycube.backendtest.Entity.Lotto;
import kr.co.polycube.backendtest.Enums.Rank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class WinnerDto {
    private Lotto lotto_id;
    private Rank rank;

    @Builder WinnerDto(Lotto lotto_id, Rank rank){
        this.lotto_id = lotto_id;
        this.rank = rank;
    }
}
