package com.xxx.login.demo.dao;



import com.xxx.login.demo.bean.User;
import com.xxx.login.demo.util.Result;

/**
 * 
 * 定义user的增删改查操作，所有和数据库这种user的交换都由此类完成
 * @author miao
 * @date 2017年4月17日
 */

public interface UserDao {
	
	/**
	 *新增user到数据库
	 *@param user
	 *@return 新增成功的话返回新增的user，否则返回null
	 *@thorws Exception
	 *
	 */
	Result addUser(String username,String password) throws Exception;
	
	/**
	 * 根据username获取user
	 * @param username指定的username
	 * @return 存在的话返回该user，否则返回null
	 * @throw Exception
	 * 
	 */
	User getUser(String username)throws Exception;
	
	/**
	 * 删除指定id的user
	 * @param id 要删除的user的id
	 * @return 是否删除成功
	 * @throws Exception
	 */
	boolean deleteById(String id) throws Exception;

	/**
	 * 删除指定名字的user
	 * @param username要删除的user的username
	 * @return 是否删除成功
	 * @throws Exception
	 */
	boolean deleteByName(String username)throws Exception;
}
