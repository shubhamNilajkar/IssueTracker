package com.issue_tracker.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.issue_tracker.app.models.User;


public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

	User findByContact(long contact);

}
