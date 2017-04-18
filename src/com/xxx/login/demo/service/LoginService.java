package com.xxx.login.demo.service;

import com.xxx.login.demo.util.Result;

/**
 * 定义登录注销等功能
 * @author miao
 * @date 2017年4月18日
 */

public interface LoginService {
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return 是否成功
	 * @throws Exception
	 */
	Result login(String name,String password) throws Exception;
	
	/**
	 * 注销
	 * @return 是否成功
	 */
	Result logout();
	
	/**
	 * 判断是否登录
	 * @return
	 */
	boolean isLogined();
	
	/**
	 * 获取登录名
	 * @return 
	 */
	<T> T loginName();

}
