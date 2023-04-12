package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Complain,Integer> {
}
