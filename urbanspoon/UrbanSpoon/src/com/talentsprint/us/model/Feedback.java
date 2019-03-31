package com.talentsprint.us.model;

import java.util.Date;

public class Feedback {
	private int feedbackId;
	private String comments;
	private Date feedbackDate;
	private int branchId;
	private int customerId;
	private int recipeId;
	private int rate;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getFeedbackDate() {
		

		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", comments=" + comments
				+ ", feedbackDate=" + feedbackDate + ", branchId=" + branchId
				+ ", customerId=" + customerId + ", recipeId=" + recipeId
				+ ", rate=" + rate + ", firstName=" + firstName + "]";
	}

	
}
