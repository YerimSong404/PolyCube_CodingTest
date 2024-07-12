package kr.co.polycube.backendtest.Service;

import kr.co.polycube.backendtest.Dto.LottoDto;
import kr.co.polycube.backendtest.Entity.Lotto;
import kr.co.polycube.backendtest.Repository.LottoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LottoService {
    private final LottoRepository lottoRepository;
    private final Random random = new Random();

    @Transactional
    public Lotto createLotto(){
        int[] num = new int[6];
        for (int i = 0; i < 6; i++) {
            num[i] = random.nextInt(45) + 1;
        }
        Lotto lotto = Lotto.builder()
                .number_1(num[0])
                .number_2(num[1])
                .number_3(num[2])
                .number_4(num[3])
                .number_5(num[4])
                .number_6(num[5])
                .build();
        lotto = lottoRepository.save(lotto);

        return lotto;
    }

}
