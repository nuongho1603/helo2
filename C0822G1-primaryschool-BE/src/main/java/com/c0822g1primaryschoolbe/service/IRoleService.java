package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.entity.account.Account;
import com.c0822g1primaryschoolbe.entity.account.Role;
import com.c0822g1primaryschoolbe.entity.account.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
