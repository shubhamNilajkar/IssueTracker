package com.issue_tracker.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.issue_tracker.app.Dao.AdminDao;
import com.issue_tracker.app.Dao.CategoryDao;
import com.issue_tracker.app.Dao.IssueDao;
import com.issue_tracker.app.models.Admin;
import com.issue_tracker.app.models.Category;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.services.AdminServices;
import com.issue_tracker.app.services.CategoryServices;
import com.issue_tracker.app.services.IssueServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	AdminServices adminService;
	@Autowired
	CategoryServices categoryService;
	@Autowired
	IssueServices issueService;
	
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping("saveAdmin")
	@ResponseBody
	public String saveAdmin(@RequestBody Admin a ) {
		System.out.println(a);
		adminDao.save(a);
		return "saved";
	}
	
	@RequestMapping("getAdmin")
	public List<Admin> getAdmin() {
		return adminDao.findAll();
	}
	
	@PostMapping("getAdminPassword")
	public String getAdmin(@RequestBody Admin admin) {
		return adminService.getPassword(admin.getAdminId());
	}

	@GetMapping("getCategoryList")
	public List<String> getCatagoryList() {
		return categoryService.getCategoryList();
	}

	@PostMapping("addCategory")
	public String addCategory(@RequestBody Category catagory) {
		return categoryService.addCategory(catagory);
	}


	@GetMapping("getCategory")
	public List<Category> getCategory() {
		return categoryService.getCategory();
	}

	@PutMapping("updateCategory")
	public String updateCategory(@RequestBody Category catagory) {		
		return categoryService.updateCatagory(catagory);
	}

	@GetMapping("getCategoryById/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getById(id);
	}

	@DeleteMapping("deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		return categoryService.deleteCategory(id);
	}
	
	@GetMapping("getIssueHistory")
	public List<Issue> viewHistory() {
		return issueService.getAllIssues();
	}
}