package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.entity.User;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user_table WHERE user_id =?1",nativeQuery = true)
    User findById(int id);

    @Query(value = "SELECT * FROM user_table WHERE role ='STUDENT'",nativeQuery = true)
    List<User> findStudents();

    @Query(value = "SELECT * FROM user_table WHERE role ='SUBWARDEN'",nativeQuery = true)
    List<User> findSubWardens();
    @Query(value = "SELECT * FROM user_table WHERE user_name =?1",nativeQuery = true)
    User findByUserName(String name);

//    @Query(value = "SELECT * FROM user_table WHERE role =?1",nativeQuery = true)
//    List<UserDto> getSubWardenList(String role);

}
