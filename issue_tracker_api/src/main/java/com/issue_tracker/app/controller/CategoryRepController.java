package com.issue_tracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.issue_tracker.app.models.Category;
import com.issue_tracker.app.models.CategoryRep;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.services.CategoryRepServices;
import com.issue_tracker.app.services.IssueServices;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/category/")
public class CategoryRepController {
	@Autowired
	CategoryRepServices categoryRepService;
	
	@Autowired
	IssueServices issueService;
	
	@PostMapping("saveCategoryRep")
	public String saveCategoryRepDetails(@RequestBody CategoryRep categoryRep) {
		return categoryRepService.saveDetails(categoryRep);
	}
	
	@PostMapping("getCategoryRep")
	public CategoryRep getCategoryRep(@RequestBody CategoryRep categoryRep) {
		return categoryRepService.getByUsername(categoryRep.getUsername());
	}
	
	@GetMapping("getIssueById/{id}")
	public Issue getCategoryById(@PathVariable int id) {
		return issueService.getById(id);
	}
	
	@PutMapping("updateIssue")
	public String updateIssue(@RequestBody Issue issue) {
		return issueService.updateIssue(issue);
	}
}
