package com.chinasofti.blc.tiremusic.user.service;

import com.chinasofti.blc.tiremusic.user.dao.UserLoginDao;
import com.chinasofti.blc.tiremusic.user.entity.User;

public class UserLoginService {
	public User userLoginByUname(String condition,String upassword){
		UserLoginDao userlogindao = new UserLoginDao();
		return userlogindao.loginByUname(condition, upassword);
	}
	public User userLoginByUemail(String condition,String upassword){
		UserLoginDao userlogindao = new UserLoginDao();
		return userlogindao.loginByUemail(condition, upassword);
	}
	public User userLoginByUtelephone(String condition,String upassword){
		UserLoginDao userlogindao = new UserLoginDao();
		return userlogindao.loginByUtelephone(condition, upassword);
	}
}
