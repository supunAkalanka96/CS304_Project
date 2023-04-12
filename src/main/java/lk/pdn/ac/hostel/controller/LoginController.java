package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.dto.LoginLogDto;
import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/allLogins")
    public List<LoginDto> getAllLogins(){
        return loginService.getAllLoginDetails();
    }

    @GetMapping("/detailByLoginId/{id}")
    public LoginDto getDetailsById(@PathVariable int id){
        return loginService.getByLoginId(id);
    }

    @GetMapping("/detailByUserId/{userId}")
    public LoginDto getDetailsByUserId(@PathVariable int userId){
        return loginService.getDetailsByUserId(userId);
    }

    @GetMapping("/data/{email}")
    public LoginLogDto getDetailsById(@PathVariable String email){
        return loginService.getDetailsByEmail(email);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto data){
        return  loginService.login(data);
    }

}
