package kr.co.polycube.backendtest.Entity;

import kr.co.polycube.backendtest.Enums.Rank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Winner {
    @Id
    private Long id;

    @JoinColumn(name = "lotto_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lotto lotto_id;

    private Rank rank;

    @Builder
    private Winner(Long id, Lotto lotto_id, Rank rank){
        this.id = id;
        this.lotto_id = lotto_id;
        this.rank = rank;
    }
}
