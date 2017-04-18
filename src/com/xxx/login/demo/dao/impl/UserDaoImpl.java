package com.xxx.login.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.xxx.login.demo.bean.User;
import com.xxx.login.demo.dao.UserDao;
import com.xxx.login.demo.util.DBUtils;
import com.xxx.login.demo.util.EncryptUtils;
import com.xxx.login.demo.util.Result;

/**
 * 实现user的增删改查的操作
 * @author miao
 * @date 2017年4月17日
 */

public class UserDaoImpl implements UserDao{
	//日志记录
	private static final Logger logger=LoggerFactory.getLogger(UserDaoImpl.class);
	
	/**
	 * 每次请求都创建新的connection，这么做是不合理的，实际项目中都用数据库连接池
	 */
	private Connection connection=null;
	public UserDaoImpl() throws SQLException{
		connection=DBUtils.getConnection();
	}
	
	@Override
	public Result addUser(String username,String password)throws Exception{
		//首先判断该用户名是否已存在
		User user=getUser(username);
		if(user!=null){
			return new Result(false,"用户名已存在");
			
		}
		String id=generateId();  //给user生成id
		
		PreparedStatement statement=connection.prepareStatement("insert into user values(?,?,?)");
		statement.setString(1, id);
		statement.setString(2, username);
		statement.setString(3, EncryptUtils.encript(password));    //保存是加密的密码
		statement.execute();  //执行sql语句
		
		if(statement.getUpdateCount()>0){
			User addedUser=new User(id,username,password);
			logger.info("user added[{}]",addedUser);
			return new Result(true,"添加用户成功");
		}else{
			logger.warn("failed to add user[name={},password={}]", username, password);
			return new Result(false,"添加用户失败");
		}
	}
	
	@Override
	public User getUser(String username)throws Exception{
		PreparedStatement statement=connection.prepareStatement("select * from user where username=?");
		statement.setString(1, username);
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
			//查询到结果
			String id=rs.getString(1);
			String password=rs.getString(3);
			User user=new User(id,username,password);
			logger.info("get user[{}]", user);
			return user;
		}else{
			logger.info("failed to get user[name={}]",username);
			return null;
		}
	}
	
	@Override
	public boolean deleteById(String id)throws Exception{
		PreparedStatement statement=connection.prepareStatement("delete form user where id=?");
		statement.setString(1,id);
		
		statement.execute();
		boolean success=false;
		if(statement.getUpdateCount()>0){
			//删除成功
			logger.info("delete user[id={}]",id);
			success=true;
		}else{
			logger.warn("failed to delete user[id={}]",id);
			success=false;
		}
		return success;
	}
	
	@Override
	public boolean deleteByName(String username) throws Exception{
		PreparedStatement statement=connection.prepareStatement("delete from user where username=?");
		statement.setString(1,username);
		statement.execute();
		boolean success=false;
		if(statement.getUpdateCount()>0){
			//删除成功
			logger.info("delete user[name={}]",username);
			success=true;
		}else{
			logger.warn("failed to delete user[user={}]", username);
			success=false;
		}
		return success;
		
	}
	
//	public User findId(String id){
//		PreparedStatement statement=connection.prepareStatement("select * from user where id="+id);
//		statement.setString(1, id);
//	}
	
	/**
	 * 生成随机串，再单机环境下唯一，实际项目中不能这么做
	 * @return
	 */
	private String generateId(){
		return UUID.randomUUID().toString();
	}

}
