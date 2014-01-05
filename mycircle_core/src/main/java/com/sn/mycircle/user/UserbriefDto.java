package com.sn.mycircle.user;

import java.util.List;

/**
 * 
 * @author MJ_LEE
 *
 */
public class UserbriefDto {

	private Integer id;
	private String login;
	private String password;
	private Boolean active;
	private Boolean registration;
	private List<RoleDto> roles;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getActive() {
		return active;
	}
	public void setRegistration(Boolean registration) {
		this.registration = registration;
	}
	public Boolean getRegistration() {
		return registration;
	}
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	public List<RoleDto> getRoles() {
		return roles;
	}

}
