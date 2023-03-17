package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.dto.LoginDto;
import lk.pdn.ac.hostel.entity.Login;
import lk.pdn.ac.hostel.repository.LoginRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LoginDto> getAllLogins(){
        List<Login> logins = loginRepository.findAll();
        return modelMapper.map(logins,new TypeToken<ArrayList<LoginDto>>(){}.getType());
    }

}
