package com.cg.onlineassesment.dao;

public class AdminDTO {
	
	private int adminId;
	
	private String emailId;
	private Long mobileNumber;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + "]";
	}
	

}
