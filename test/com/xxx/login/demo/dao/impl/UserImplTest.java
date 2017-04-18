package com.xxx.login.demo.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.junit.Test;

import com.xxx.login.demo.dao.UserDao;

/**
 * 
 * @author miao
 * @date 2017年4月18日
 */

public class UserImplTest {
	@Test
	public void testAdd() throws Exception{
		UserDao dao=new UserDaoImpl();
		dao.addUser("zhangsan", "123");
	}
	
	@Test
	public void testDeleteById() throws Exception{
		UserDao dao =new UserDaoImpl();
		dao.deleteById("2");
	}
	
	@Test
	public void testDeleteByName() throws Exception{
		UserDao dao=new UserDaoImpl();
		dao.deleteByName("zhangsan");
	}
	
	@Test
	public void testGetUser() throws Exception{
		UserDao dao =new UserDaoImpl();
		dao.addUser("lisi", "abc");
	}
	
	@Test
	public void md5() throws NoSuchAlgorithmException{
		String text="abc";
		MessageDigest md5=MessageDigest.getInstance("md5");
		byte[] bytes=md5.digest(text.getBytes());
		String cipher=new String(Base64.getEncoder().encode(bytes));
		System.out.println(cipher);
	}

}
