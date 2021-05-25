package com.issue_tracker.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue_tracker.app.models.Issue;



public interface IssueDao extends JpaRepository<Issue, Integer> {

}
