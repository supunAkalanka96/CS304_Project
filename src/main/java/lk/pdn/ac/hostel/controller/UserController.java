package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.dto.SignUpDto;
import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.entity.User;
import lk.pdn.ac.hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody SignUpDto userDto){
        return userService.addStudent(userDto);
    }

    @PostMapping("/saveSubWarden")
    public UserDto saveSubWarden(@RequestBody SignUpDto userDto){
        return userService.addSubWarden(userDto);
    }

    @GetMapping("/allUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getUser/{id}")
    public UserDto getById(@PathVariable int id){
        return userService.getDetailsById(id);
    }

    @GetMapping("/name/{name}")
    public UserDto getByName(@PathVariable String name){
        return userService.getDetailsByUserName(name);
    }

    @GetMapping("/students")
    public List<UserDto> getStudentsData(){
        return userService.getStudentsRecorde();
    }

    @GetMapping("/subwardens")
    public List<UserDto> getSubWardensData(){
        return userService.getSubWardensRecorde();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return userService.deleteUserById(id);
    }

}
