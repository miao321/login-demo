package com.xxx.login.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.login.demo.service.RegisterService;
import com.xxx.login.demo.service.impl.RegisterServiceImpl;
import com.xxx.login.demo.util.PathUtils;
import com.xxx.login.demo.util.Result;

/**
 * 处理注册请求
 * @author miao
 * @date 2017年4月18日
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID=6003036540532409614L;
	private static final Logger logger=LoggerFactory.getLogger(RegisterServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//实现注册功能
		RegisterService registerService=null;
		Result result=null;
		try{
			registerService=new RegisterServiceImpl();
			//获取网页表单的内容
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			result=registerService.register(username, password);
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);				

		}catch(Exception e){
			//数据库连接创建失败
			logger.error("{}", e);
			//设置错误信息，以便error.jsp中显示
			request.setAttribute("error", new com.xxx.login.demo.util.Error(e.getMessage(), e.getCause()));
			//跳转到全局错误处理页面error.jsp
			request.getRequestDispatcher(PathUtils.JSP_ERROR).forward(request, response);
		}
		
		if(result.isSuccess()){
			//注册成功,跳转到login.jsp
			//request.setAttribute("username", registerService.loginName());
			request.getRequestDispatcher(PathUtils.JSP_LOGIN).forward(request, response);
		}else{
			request.setAttribute("result", result);
			request.getRequestDispatcher(PathUtils.JSP_REGISTER).forward(request, response);
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
