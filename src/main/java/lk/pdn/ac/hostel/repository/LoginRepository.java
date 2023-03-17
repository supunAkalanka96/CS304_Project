package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {
}
