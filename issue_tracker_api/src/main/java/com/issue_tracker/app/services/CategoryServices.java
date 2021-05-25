package com.issue_tracker.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue_tracker.app.Dao.CategoryDao;
import com.issue_tracker.app.models.Category;

@Service
public class CategoryServices {
	@Autowired
	CategoryDao categoryDao;

	public ArrayList<String> getCategoryList() {
		ArrayList<String> CatagoryList = new ArrayList<String>();
		for (Category catagory : categoryDao.findAll())
			CatagoryList.add(catagory.getCategoryType());
		return CatagoryList;
	}

	public String addCategory(Category catagory) {
		try{
			categoryDao.save(catagory);
			}catch (Exception e) {
				System.out.println(e);
				return "categoryType already present";
			}
		return "new category added";
	}

	public List<Category> getCategory() {
		return categoryDao.findAll();
	}

	public String updateCatagory(Category catagory) {
		int catagoryId = catagory.getCategoryId();
		Category updatedCatagory = categoryDao.getOne(catagoryId);
		updatedCatagory.setCategoryType(catagory.getCategoryType());
		updatedCatagory.setCategoryDescription(catagory.getCategoryDescription());
		categoryDao.save(updatedCatagory);
		return "catagory updated";
	}

	public String deleteCategory(int id) {
		categoryDao.deleteById(id);
		return "deleted";
	}

	public Category getById(int id) {
		return categoryDao.findById(id).get();

	}
}
