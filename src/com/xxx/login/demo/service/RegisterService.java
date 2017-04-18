package com.xxx.login.demo.service;

import com.xxx.login.demo.util.Result;

/**
 * 注册服务
 * @author miao
 * @date 2017年4月18日
 */

public interface RegisterService {
	/**
	 * 注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 注册结果
	 * @throws Exception
	 */
	Result register(String username,String password)throws Exception;

}
