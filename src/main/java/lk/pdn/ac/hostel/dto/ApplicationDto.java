package lk.pdn.ac.hostel.dto;

import lk.pdn.ac.hostel.Enum.HostelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

    private int applicationId;
    private String faculty;
    private HostelType hostelType;
    private String hostelName;
    private int distance;
    private Date date;
    private int userId;


}
