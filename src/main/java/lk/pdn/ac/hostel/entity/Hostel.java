package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hostel_table")
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelId;
    private String hostelName;
    private String hostelType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "hostel")
    @JoinColumn(name = "roomId",referencedColumnName = "roomId")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hostel")
    private List<Facility> facilities;

}
