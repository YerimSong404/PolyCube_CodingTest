package kr.co.polycube.backendtest.Batch;


import kr.co.polycube.backendtest.Service.LottoService;
import kr.co.polycube.backendtest.Service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LottoBatch {

    private final LottoService lottoService;
    private final WinnerService winnerService;

    @Scheduled(cron = "0 0 0")
    public void checkWinner(){

    }
}
