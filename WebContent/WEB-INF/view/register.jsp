<%@ page import="com.xxx.login.demo.util.Result" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String path=request.getContextPath();
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	Result result=(Result) request.getAttribute("result");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/3.1.0/jquery.js"> </script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
<title>注册</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" style="background:#272727;color:white">
		<div class="container">
			<div class="row" style="font-size:20px;margin-top:10px;">
				<div class="col-sm-12">
					注册
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" style="margin-top:100px;align:center">
		<div class="col-sm-offset-4 col-sm-4">
			<form action="Register" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" name="username" class="form-control" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" name="password" class="form-control" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-primary" class="form-control" style="width:100%">注册</button>
					</div>
				</div>
				
				
				<!-- 注册 -->
				
				<!-- 判断是否有错误信息，有的话显示出来 -->
				<%
					if(result!=null){
				%>
				<div align="left" style="color:red">
					<%=result.getReason() %>
				</div>
				<%
					}
				%>
			</form>
		</div>
	</div>
</body>
</html>