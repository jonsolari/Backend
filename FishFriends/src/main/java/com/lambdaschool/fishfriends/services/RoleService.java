package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);

    Role findByName(String name);

    Role update(long id, Role role);
}