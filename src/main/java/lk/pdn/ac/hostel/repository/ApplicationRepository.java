package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {


}
