package com.issue_tracker.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue_tracker.app.Dao.IssueDao;
import com.issue_tracker.app.models.Category;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.models.User;

@Service
public class IssueServices {

	@Autowired
	IssueDao issueDao;

	public String saveIssue(Issue issue) {
		issue.setIssueStatus("new");
		issueDao.save(issue);
		return "issue saved";
		
	}

	public List<Issue> getAllIssues() {
		return issueDao.findAll();
	}

	public Issue getById(int id) {
		System.out.println(issueDao.findById(id).get());
		return issueDao.findById(id).get();		
	}

	public String updateIssue(Issue issue) {
		Issue updatedIssue=issueDao.getOne(issue.getId());
		updatedIssue.setIssueStatus(issue.getIssueStatus());
		updatedIssue.setIssueResolution(issue.getIssueResolution());
		updatedIssue.setIssueCategory(issue.getIssueCategory());
		System.out.println(updatedIssue);
		issueDao.save(updatedIssue);
		return "saved";
	}

}
