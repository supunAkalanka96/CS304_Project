package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.dto.LoginLogDto;
import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.entity.Login;
import lk.pdn.ac.hostel.entity.User;
import lk.pdn.ac.hostel.repository.LoginRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public List<LoginDto> getAllLogins(){
        List<Login> logins = loginRepository.findAll();
        return modelMapper.map(logins,new TypeToken<ArrayList<LoginDto>>(){}.getType());
    }

    public boolean validateEmail(String email){
        Login l=loginRepository.validateEmail1(email);
        if(l==null){
            return true;
        }
        return false;
    }

    public LoginDto addLoginDetails(LoginDto data){
        Login login=modelMapper.map(data, Login.class);
//        String hashedPW= passwordEncoder.encode(data.getPassword());
//        login.setPassword(hashedPW);
        Login l=loginRepository.save(login);
        if(login!=null){
//            return modelMapper.map(login,new TypeToken<LoginDto>(){}.getType());
            return modelMapper.map(l,new TypeToken<LoginDto>(){}.getType());
        }
        return null;
    }

    public List<LoginDto> getAllLoginDetails(){
        try{
            List<Login> logins = loginRepository.findAll();
            return modelMapper.map(logins,new TypeToken<LoginDto>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public LoginDto getByLoginId(int loginId){
        Login login = loginRepository.getLoginDetailsById(loginId);
        return modelMapper.map(login,LoginDto.class);
    }
    public LoginLogDto getDetailsByEmail(String email){
        Login login = loginRepository.getDetailsByEmail(email);
        return modelMapper.map(login,LoginLogDto.class);
    }

    public LoginDto getDetailsByUserId(int userId){
        Login login = loginRepository.getLoginDetailsByUserId(userId);
        return modelMapper.map(login,LoginDto.class);
    }

    public UserDto login(LoginDto data) {
//        String hashedPassword= passwordEncoder.encode(data.getPassword());
        Login login=loginRepository.login(data.getEmail(), data.getPassword());
        if(login!=null){
            System.out.println("user null");
            return userService.getDetailsById(login.getUser().getUserId());
        }
        return null;
    }

    //check password

}
