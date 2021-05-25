package com.issue_tracker.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue_tracker.app.models.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
		Admin findByAdminId(String adminId);
		
}
