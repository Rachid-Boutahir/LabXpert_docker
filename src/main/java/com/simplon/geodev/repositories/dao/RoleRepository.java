package com.simplon.geodev.repositories.dao;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.simplon.geodev.Enum.ERole;
import com.simplon.geodev.models.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
