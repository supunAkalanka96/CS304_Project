package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lk.pdn.ac.hostel.Enum.HostelType;
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
    private int noOfRooms;
    @Enumerated(EnumType.STRING)
    private HostelType hostelType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "hostel")
     private List<Room> rooms;

    @OneToMany(mappedBy = "hostel")
    private List<Facility> facilities;

}
