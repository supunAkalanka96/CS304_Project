package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/allLogins")
    public List<LoginDto> getAllLogins(){
        return loginService.getAllLogins();
    }

}
