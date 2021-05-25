package com.issue_tracker.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.models.User;
import com.issue_tracker.app.services.IssueServices;
import com.issue_tracker.app.services.UserServices;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/user/")
public class UserController {
	@Autowired
	UserServices userService;

	@Autowired
	IssueServices issueService;
		
	@PostMapping("getUserPassword")
	public String getAdmin(@RequestBody User user) {
		String username=user.getUsername();
		return userService.getPassword(username);
	}
	
	@PostMapping("saveUser")
	public User saveUserDetails(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
	
	@PostMapping("saveIssue")
	public Issue saveIssueDetails(@RequestBody Issue issue) {
		issueService.saveIssue(issue);
		return issue;
	}

	@PostMapping("forgotUserId")
	public User getUsername(@RequestBody User user) {
		return userService.getUserByContact(user.getContact());
	}	
	
	@PostMapping("forgotPassword")
	public User getUserByUsername(@RequestBody User user) {
		return userService.getUserByUsername(user.getUsername());
	}
	
	@PutMapping("updatePassword")
	public String updatePassword(@RequestBody User user) {
		return userService.updatePassword(user);
	}
	
	@PutMapping("reopenIssue")
	public String reopenIssue(@RequestBody Issue issue) {
		return userService.reopenIssue(issue);
	}
}
