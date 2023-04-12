package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lk.pdn.ac.hostel.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String gender;
    private String mobile;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Login login;

    @OneToMany(mappedBy = "user")
    private List<StudentComplain> studentComplains;

    @OneToOne(mappedBy = "user")
    private Payment payment;

    @OneToOne(mappedBy = "user")
    private Application application;

    @OneToMany(mappedBy = "user")
    private List<Complain> complains;

    @OneToMany(mappedBy = "user")
    private List<Issue> issues;

    @OneToOne(mappedBy = "user")
    private Hostel hostel;

}

