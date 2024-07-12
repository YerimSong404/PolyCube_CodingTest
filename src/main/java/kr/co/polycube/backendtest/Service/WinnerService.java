package kr.co.polycube.backendtest.Service;

import kr.co.polycube.backendtest.Dto.WinnerDto;
import kr.co.polycube.backendtest.Entity.Winner;
import kr.co.polycube.backendtest.Repository.WinnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WinnerService {
    private final WinnerRepository winnerRepository;

    @Transactional
    public WinnerDto createWinner(WinnerDto winnerDto){
        Winner winner = Winner.builder()
                .lotto_id(winnerDto.getLotto_id())
                .rank(winnerDto.getRank())
                .build();

       winner =  winnerRepository.save(winner);

        return WinnerDto.builder()
                .lotto_id(winner.getLotto_id())
                .rank(winner.getRank())
                .build();
    }
}
