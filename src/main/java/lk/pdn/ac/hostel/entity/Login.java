package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_table")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
}
