package com.ofaul.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofaul.business.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsernameAndPassword(String username, String password);
}
