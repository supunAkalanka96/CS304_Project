package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue
    private int roleId;
    private String roleName;

    @OneToOne(mappedBy = "role",cascade = CascadeType.ALL)
    private User user;

    @OneToOne(mappedBy = "role",cascade = CascadeType.ALL)
    private Login login;

}
