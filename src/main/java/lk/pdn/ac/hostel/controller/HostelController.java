package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.HostelDto;
import lk.pdn.ac.hostel.entity.Hostel;
import lk.pdn.ac.hostel.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hostel")
@CrossOrigin("*")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("/addHostel")
    public HostelDto addHostel(@RequestBody HostelDto hostelDto){
        return hostelService.save(hostelDto);
    }

    @GetMapping("/hostels")
    public List<HostelDto> getAllHostels(){
        return hostelService.allHostels();
    }
}
