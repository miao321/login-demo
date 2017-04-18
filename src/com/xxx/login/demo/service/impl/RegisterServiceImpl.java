package com.xxx.login.demo.service.impl;

import com.xxx.login.demo.dao.UserDao;
import com.xxx.login.demo.dao.impl.UserDaoImpl;
import com.xxx.login.demo.service.RegisterService;
import com.xxx.login.demo.util.Result;

/**
 * 注册服务实现
 * @author miao
 * @date 2017年4月18日
 */

public class RegisterServiceImpl implements RegisterService {
	@Override
	public Result register(String username,String password) throws Exception{
		UserDao dao=new UserDaoImpl();
		Result result=dao.addUser(username, password);
		return result;
	}

}
