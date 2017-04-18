package com.xxx.login.demo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.login.demo.service.LoginService;
import com.xxx.login.demo.service.impl.LoginServiceImpl;
import com.xxx.login.demo.util.PathUtils;

/**
 * 注销请求处理
 * @author miao
 * @date 2017年4月18日
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 2825056057074940125L;
	private static final Logger logger=LoggerFactory.getLogger(LogoutServlet.class);
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			LoginService loginService=new LoginServiceImpl(request.getSession());
			//注销
			loginService.logout();
			//跳转到首页index.jsp
			request.getRequestDispatcher(PathUtils.SERVLET_INDEX).forward(request, response);
		}catch(SQLException e){
			//数据库连接创建失败
			logger.error("{}", e);
			//设置错误信息，以便error.jsp中显示
			request.setAttribute("error", new com.xxx.login.demo.util.Error("数据库异常", e.getCause()));
			//跳转到全局错误处理页面error.jsp
			request.getRequestDispatcher(PathUtils.JSP_ERROR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
