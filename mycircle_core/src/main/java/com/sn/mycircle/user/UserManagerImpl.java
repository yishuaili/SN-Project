package com.sn.mycircle.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager{

	@Resource
	private UserbriefDao userDao;
	
	protected static Logger logger = Logger.getLogger("service");

	/**
	 * Check the login user
	 */
	@Override
	public String checkLogin( String login, String password) {
		logger.debug("service: check user login and password");
		List<Userbrief> logins = userDao.getAll();
		boolean bname = false,bpassword =false;
		for (Userbrief l : logins) {	
			bname = l.compareLoginName(login);
			bpassword = l.comparePassword(password);
			if(bname){
				if(bpassword)
					return "yes";
				else
					return "Password Wrong!";
			}
		}
		return "User Name does not exist";
		
	}

	/**
	 * Get user information by name
	 */
	@Override
	public UserDto getUserInfo(String login) {
		logger.debug("service: get user information by login name");
		List<Userbrief> logins = userDao.getAll();
		for (Userbrief l : logins) {
			if(l.compareLoginName(login))
				return l.createUserDto();
		}
		logger.error("service: user not found");
		return null;
	}
	
	

}
