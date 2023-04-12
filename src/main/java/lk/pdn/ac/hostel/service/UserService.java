package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.Enum.Role;
import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.dto.SignUpDto;
import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.entity.Login;
import lk.pdn.ac.hostel.entity.User;
import lk.pdn.ac.hostel.repository.LoginRepository;
import lk.pdn.ac.hostel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginRepository loginRepository;
//    @Autowired
//    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return modelMapper.map(users,new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

    public UserDto addStudent(SignUpDto data){
        try{
           boolean validate= loginService.validateEmail(data.getUserEmail());

           if(validate && data.getRole()==Role.STUDENT){
               User newUser=new User();
               newUser.setUserName(data.getUserName());
               newUser.setGender(data.getGender());
               newUser.setRole(Role.STUDENT);
               newUser.setMobile(data.getMobile());

               User u=userRepository.save(newUser);
               if(u!=null){
//                   String hashedPassword= passwordEncoder.encode(data.getPassword());
                   String hashedPassword= data.getPassword();
                   Login l=new Login(0, data.getUserEmail(),hashedPassword, u);
                   LoginDto logindto=modelMapper.map(l,new TypeToken<LoginDto>(){}.getType());
                   LoginDto k=loginService.addLoginDetails(logindto);
                   if(k!=null){
                       return modelMapper.map(u,new TypeToken<UserDto>(){}.getType());
                   }
                   else{
                       return null;
                   }
               }
               return null;
           }
           else{
               return null;
           }
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public UserDto addSubWarden(SignUpDto data){
        try{
            boolean validate= loginService.validateEmail(data.getUserEmail());

            if(validate && data.getRole()==Role.SUBWARDEN){
                User newUser=new User();
                newUser.setUserName(data.getUserName());
                newUser.setGender(data.getGender());
                newUser.setRole(Role.SUBWARDEN);
                newUser.setMobile(data.getMobile());

                User u=userRepository.save(newUser);
                if(u!=null){
//                    String hashedPassword= passwordEncoder.encode(data.getPassword());
                    String hashedPassword= data.getPassword();
                    Login l=new Login(0, data.getUserEmail(),hashedPassword, u);
                    LoginDto logindto=modelMapper.map(l,new TypeToken<LoginDto>(){}.getType());
                    LoginDto k=loginService.addLoginDetails(logindto);
                    if(k!=null){
                        return modelMapper.map(u,new TypeToken<UserDto>(){}.getType());
                    }
                    else{
                        return null;
                    }
                }
                return null;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public UserDto getDetailsById(int id){

        User user = userRepository.findById(id);

        return modelMapper.map(user,UserDto.class);

    }

    public UserDto getDetailsByUserName(String name){

        User user = userRepository.findByUserName(name);

        return modelMapper.map(user,UserDto.class);

    }

    public List<UserDto> getStudentsRecorde(){
        List<User> user = userRepository.findStudents();
        return modelMapper.map(user,new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

    public List<UserDto> getSubWardensRecorde(){
        List<User> user = userRepository.findSubWardens();
        return modelMapper.map(user,new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

    public String deleteUserById(int id){
        User u = userRepository.findById(id);
        if(u != null) {
            userRepository.deleteById(id);
            return "deleted";
        }
        return null;
    }

}

