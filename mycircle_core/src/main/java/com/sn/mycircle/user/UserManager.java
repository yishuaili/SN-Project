package com.sn.mycircle.user;


public interface UserManager {
	public String checkLogin(String login, String password);
	public UserDto getUserInfo(String login);
}
