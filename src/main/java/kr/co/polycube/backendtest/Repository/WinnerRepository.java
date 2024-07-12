package kr.co.polycube.backendtest.Repository;

import kr.co.polycube.backendtest.Entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long> {

}
