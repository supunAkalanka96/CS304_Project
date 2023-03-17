package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
