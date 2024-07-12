package kr.co.polycube.backendtest.Controller;

import kr.co.polycube.backendtest.Entity.Lotto;
import kr.co.polycube.backendtest.Service.LottoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lottos")
public class LottoController {

    private final LottoService lottoService;

    @PostMapping
    public ResponseEntity<Lotto> createLotto(){
        Lotto createdLotto = lottoService.createLotto();
        return ResponseEntity.ok(createdLotto);
    }
}
