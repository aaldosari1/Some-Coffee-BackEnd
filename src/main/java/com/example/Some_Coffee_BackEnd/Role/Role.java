package com.example.Some_Coffee_BackEnd.Role;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String name;

    public Role() {
    }

    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Long getId() {
        return roleId;
    }

    public void setId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

