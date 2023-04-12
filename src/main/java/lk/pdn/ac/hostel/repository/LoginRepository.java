package lk.pdn.ac.hostel.repository;

import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.entity.Login;
import lk.pdn.ac.hostel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    @Query("select l from Login l where l.email = ?1")
    Login validateEmail1(String email);
//    @Query(value = "SELECT Login l WHERE l.loginEmail=?1",nativeQuery = true)
//    public Login validateEmail(String email);

    @Query(value = "SELECT * FROM login_table WHERE login_id =?1",nativeQuery = true)
    Login getLoginDetailsById(int id);

    @Query(value = "SELECT * FROM login_table WHERE user_id =?1",nativeQuery = true)
    Login getLoginDetailsByUserId(int id);

    @Query(value = "SELECT * FROM login_table WHERE email =?1",nativeQuery = true)
    Login getDetailsByEmail(String userEmail);

    @Query(value = "SELECT * FROM login_table WHERE email=?1 AND password=?2 LIMIT 1", nativeQuery = true)
    Login login(String email, String pw);

//    @Query(value = "SELECT * FROM user_table WHERE user_id =(SELECT user_id FROM login_table email=?1 AND password =?2)");
//    User

}
