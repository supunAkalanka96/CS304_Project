package lk.pdn.ac.hostel.controller;

import lk.pdn.ac.hostel.entity.Role;
import lk.pdn.ac.hostel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/allRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

}
