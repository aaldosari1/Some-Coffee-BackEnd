package com.example.Some_Coffee_BackEnd.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "role")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable String id) {
        return roleService.getRole(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable String id, @RequestBody Role data) {
        roleService.updateRole(id, data);
    }
}

