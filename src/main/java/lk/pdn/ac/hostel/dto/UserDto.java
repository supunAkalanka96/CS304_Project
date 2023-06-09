package lk.pdn.ac.hostel.dto;

import lk.pdn.ac.hostel.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String userName;
    private String gender;
    private Role role;
    private String mobile;

}
