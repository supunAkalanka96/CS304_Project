package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lk.pdn.ac.hostel.Enum.HostelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application_table")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;
    private String faculty;
    @Enumerated(EnumType.STRING)
    private HostelType hostelType;
    private String hostelName;
    private int distance;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

}
