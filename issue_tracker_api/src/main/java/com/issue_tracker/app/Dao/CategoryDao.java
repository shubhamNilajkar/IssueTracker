package com.issue_tracker.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue_tracker.app.models.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
