package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.datamodel.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

}