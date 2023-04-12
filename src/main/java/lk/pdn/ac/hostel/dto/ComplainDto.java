package lk.pdn.ac.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplainDto {

    private int complainId;
    private String description;
    private int userId;

}
