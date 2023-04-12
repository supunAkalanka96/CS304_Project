package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository extends JpaRepository<Hostel,Integer> {
}
