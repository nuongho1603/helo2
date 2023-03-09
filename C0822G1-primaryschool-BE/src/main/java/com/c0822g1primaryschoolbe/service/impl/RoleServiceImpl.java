package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.entity.account.Role;
import com.c0822g1primaryschoolbe.entity.account.RoleName;
import com.c0822g1primaryschoolbe.repository.IRoleRepository;
import com.c0822g1primaryschoolbe.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;


    @Override
    public Optional<Role> findByName(RoleName name) {
        return iRoleRepository.findByName(name);
    }
}
