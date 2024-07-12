package kr.co.polycube.backendtest.Repository;

import kr.co.polycube.backendtest.Entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoRepository extends JpaRepository<Lotto, Long> {
}
