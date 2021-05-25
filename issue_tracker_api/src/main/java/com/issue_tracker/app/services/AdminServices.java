package com.issue_tracker.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue_tracker.app.Dao.AdminDao;
import com.issue_tracker.app.models.Admin;

@Service
public class AdminServices {
	@Autowired
	AdminDao adminDao;
	
	public String getPassword(String adminId) {
		Admin admin=adminDao.findByAdminId(adminId);
		if(admin != null)
			return  admin.getPassword();
		else
			return "unavailable";
	}
}
