package com.xxx.login.demo.bean;

/**
 * 封装User的信息
 * @author miao
 * @date 2017年4月17日
 */

public class User {
	/**
	 * 名字是否合法
	 * @param
	 * @return
	 */
	public static boolean validName(String name){
		return name!=null && !name.equals("");
	}
	
	/**
	 * 密码是否合法
	 * @param passwd
	 * @return
	 */
	public static boolean validPasswd(String passwd){
		return passwd!=null&&!passwd.equals("");
	}
	
	/**
	 * 名字和密码是否正确
	 * @param name
	 * @param password
	 * @return
	 */
	public static boolean valid(String name,String password){
		return validName(name)&& validPasswd(password);
	}
	
	
	private String id;
	private String username;
	private String password;
	
	public User(){
		
	}
	public User(String id,String username,String password){
		super();
		this.id=id;
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString(){
		return String.format("user[id=%s,name=%s,password=%s]", id,username,password);
	}
	
	

}
