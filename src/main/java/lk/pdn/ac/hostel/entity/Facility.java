package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facility_table")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityId;
    private int canteen;
    private int studyRoom;
    private int sportItems;

    @ManyToOne
    @JoinColumn(name = "hostelId",referencedColumnName = "hostelId")
    private Hostel hostel;

}
