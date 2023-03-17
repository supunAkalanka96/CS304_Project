package lk.pdn.ac.hostel.dto;

import lk.pdn.ac.hostel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private int loginId;
    private String email;
    private String password;
    private User user;

}
