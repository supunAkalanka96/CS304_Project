package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.ApplicationDto;
import lk.pdn.ac.hostel.entity.Application;
import lk.pdn.ac.hostel.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/send")
    public ApplicationDto sendApplication(@RequestBody ApplicationDto applicationDto){
        return applicationService.saveApplication(applicationDto);
    }

    @GetMapping("/applications")
    public List<ApplicationDto> getAllApplications(){
        return applicationService.getAllApplications();
    }

}
