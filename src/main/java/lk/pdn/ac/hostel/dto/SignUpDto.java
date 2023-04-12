package lk.pdn.ac.hostel.dto;

import lk.pdn.ac.hostel.Enum.Role;
import lombok.Data;

@Data
public class SignUpDto {

    private String userName;
    private String userEmail;
    private String gender;
    private String mobile;
    private String password;
    private Role role;

}
