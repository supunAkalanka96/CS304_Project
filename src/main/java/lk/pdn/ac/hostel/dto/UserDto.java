package lk.pdn.ac.hostel.dto;

import lk.pdn.ac.hostel.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String userName;
    private String userEmail;
    private String gender;
    private String mobile;
    private String password;
    private Role role;

}
