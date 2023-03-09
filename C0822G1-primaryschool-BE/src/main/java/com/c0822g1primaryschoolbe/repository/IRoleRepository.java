package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.entity.account.Role;
import com.c0822g1primaryschoolbe.entity.account.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
