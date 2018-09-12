package com.cp.labx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.labx.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
