package com.example.Some_Coffee_BackEnd.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRole(String id) {
        Long roleId = Long.parseLong(id);
        return roleRepository.findById(roleId).orElse(null);
    }

    public void deleteRole(String id) {
        //if problem occurred check here
        Long roleId = Long.parseLong(id);
        roleRepository.deleteById(roleId);
    }

    public void updateRole(String id, Role data) {
        Long roleId = Long.parseLong(id);
        Role role = roleRepository.findById(roleId).orElse(null);


        if (role != null) {
            role.setName(data.getName());
            roleRepository.save(role);
        }
    }

}

