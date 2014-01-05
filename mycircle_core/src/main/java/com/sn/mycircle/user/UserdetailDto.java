package com.sn.mycircle.user;

import java.util.Date;


public class UserdetailDto {
	
	private String lastName;
	private Boolean gender;
	private String firstName;
	private Date birthday;
	private Date lastModifiedTime;
	private Integer language;
	private String introduction;
	private String address;
	private String telephone;
	

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public Boolean getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the lastModifiedTime
	 */
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	/**
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	/**
	 * @return the language
	 */
	public Integer getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Integer language) {
		this.language = language;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephone() {
		return telephone;
	}
	
}
