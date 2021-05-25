package com.issue_tracker.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue_tracker.app.models.CategoryRep;

public interface CategoryRepDao extends JpaRepository<CategoryRep, Integer> {

	CategoryRep findByUsername(String username);

}
