package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.dto.UserDto;
import lk.pdn.ac.hostel.entity.User;
import lk.pdn.ac.hostel.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        User user1 = userRepository.save(user);
        return modelMapper.map(user1,new TypeToken<UserDto>(){}.getType());
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return modelMapper.map(users,new TypeToken<ArrayList<UserDto>>(){}.getType());
    }

}
