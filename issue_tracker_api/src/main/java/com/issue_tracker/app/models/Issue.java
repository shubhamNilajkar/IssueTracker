package com.issue_tracker.app.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Issue {
	@Id
	int id;
	String issueStatus;
	String issueName;
	String issueDescription;
	String issueResolution;
	String issueDate;
	String issueCategory;
	String username;
	String userComments;
	
	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Issue() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssueCategory() {
		return issueCategory;
	}

	public void setIssueCategory(String issueCategory) {
		this.issueCategory = issueCategory;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getIssueResolution() {
		return issueResolution;
	}

	public void setIssueResolution(String issueResolution) {
		this.issueResolution = issueResolution;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	
	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Issue [id=");
		builder.append(id);
		builder.append(", issueStatus=");
		builder.append(issueStatus);
		builder.append(", issueName=");
		builder.append(issueName);
		builder.append(", issueDescription=");
		builder.append(issueDescription);
		builder.append(", issueResolution=");
		builder.append(issueResolution);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", issueCategory=");
		builder.append(issueCategory);
		builder.append(", username=");
		builder.append(username);
		builder.append(", userComments=");
		builder.append(userComments);
		builder.append("]");
		return builder.toString();
	}

	
}
