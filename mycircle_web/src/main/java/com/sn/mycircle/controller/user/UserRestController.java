package com.sn.mycircle.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sn.mycircle.user.UserManager;

/**
 * REST Api for User.<br>
 * Path: "/api"
 * @author MJ_LEE
 */
@Controller
public class UserRestController {

	@Resource
	private UserManager userManager;
	
	protected static Logger logger =  Logger.getLogger("controller");
	
	@RequestMapping(method = RequestMethod.GET, value = "/checkLogin")
	public ResponseEntity<String> checkLogin(HttpServletRequest request, HttpServletResponse response){
		String login = request.getParameter("loginName");
		String password = request.getParameter("password");
		if(login == null || password == null){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		String result = userManager.checkLogin(login,password);
		return new ResponseEntity<String>(result,HttpStatus.OK);		
	}

	/**
	 * Get user information by login name <br>  
	 * Path: "/userInfo.json?loginName="
	 * @param request
	 * @param response
	 * @return Json Format of User Information
	 */
	@RequestMapping(method = RequestMethod.GET, value ="/userInfo")
	public ModelAndView getUserInfo(HttpServletRequest request, HttpServletResponse response){
		
		logger.debug("controller: receive a request to return the specified user information");
		
		String login = request.getParameter("loginName");
		if(login == null ){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		return new ModelAndView("userInfo","userInfo",userManager.getUserInfo(login));
		
	}
	
	/**
	 * Get user information by login Name <br> 
	 * Path: "/userInfo/{name}.json"
	 * @param loginName user login name
	 * @param request
	 * @param response
	 * @return Json Format of User Information
	 */
	@RequestMapping(method = RequestMethod.GET, value ="/userInfo/{name}")
	public ModelAndView getUserInfoByName(@PathVariable("name")String loginName, HttpServletRequest request, HttpServletResponse response){
		
		logger.debug("controller: receive a request to return the specified user information");
		
		if(loginName == null ){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		return new ModelAndView("userInfo","userInfo",userManager.getUserInfo(loginName));
		
	}
}
