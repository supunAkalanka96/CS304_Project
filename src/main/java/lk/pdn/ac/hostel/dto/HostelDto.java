package lk.pdn.ac.hostel.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.pdn.ac.hostel.Enum.HostelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostelDto {

    private int hostelId;
    private String hostelName;
    private int noOfRooms;
  //  @Enumerated(EnumType.STRING)
    private String hostelType;

}
