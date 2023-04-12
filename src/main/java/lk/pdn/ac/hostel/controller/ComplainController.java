package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.ComplainDto;
import lk.pdn.ac.hostel.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping("/send")
    public ComplainDto sendComplain(@RequestBody ComplainDto complainDto){
        return complainService.addComplain(complainDto);
    }

}
