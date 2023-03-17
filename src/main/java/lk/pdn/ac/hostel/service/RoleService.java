package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.entity.Role;
import lk.pdn.ac.hostel.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

}
