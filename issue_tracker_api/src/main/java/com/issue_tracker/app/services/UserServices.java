package com.issue_tracker.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue_tracker.app.Dao.IssueDao;
import com.issue_tracker.app.Dao.UserDao;
import com.issue_tracker.app.models.Admin;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.models.User;


@Service
public class UserServices {

	@Autowired
	UserDao userDao;
	
	@Autowired
	IssueDao issueDao;
	
	public String saveUser(User user) {
		userDao.save(user);
		return "user saved";
	}
	
	public List<User> getUser(){
		return userDao.findAll();		
	}
	
	public String getPassword(String username) {
		User user=userDao.findByUsername(username);
		if(user != null)
			return  user.getPassword();
		else
			return "unavailable";
	}

	public User getUserByContact(long contact) {
		return userDao.findByContact(contact);
	}

	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public String updatePassword(User user) {
		User updatedUser=userDao.findByUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		userDao.save(updatedUser);
		return "updated";
	}

	public String reopenIssue(Issue issue) {
		Issue updatedissue=issueDao.getOne(issue.getId());
		updatedissue.setIssueStatus(issue.getIssueStatus());
		updatedissue.setUserComments(issue.getUserComments());
		issueDao.save(updatedissue);
		return "issue reopened";
	}
}