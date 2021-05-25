package com.issue_tracker.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue_tracker.app.Dao.CategoryDao;
import com.issue_tracker.app.Dao.CategoryRepDao;
import com.issue_tracker.app.models.CategoryRep;

@Service
public class CategoryRepServices {
	@Autowired
	CategoryRepDao categoryRepDao;
	public String saveDetails(CategoryRep categoryRep) {
		categoryRepDao.save(categoryRep);
		return "saved";
	}
	
	public CategoryRep getByUsername(String username) {	
		System.out.println(categoryRepDao.findByUsername(username));
		return categoryRepDao.findByUsername(username);
	}

}
