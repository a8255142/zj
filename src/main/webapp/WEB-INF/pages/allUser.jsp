<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<style> 
/* 
css注释：设置table背景为红色，td背景为白色 */ 
</style> 
<body>
<div class="table-d"> 
		<form id="frm1" action="allUser.do" method="get"  class="navbar-form" >
			<div  class="form-group">
				<span>身份证或者姓名：</span><input type="text" id="account" value="${param.account }" name="account"  class="form-control" placeholder="Search" />
				<input  type="submit"  class="btn btn-default"  value="查询">
				<input  type="button"  class="btn btn-default" onclick="location.href='page.do'" value="添加">
			</div>	
		</form>
		<div class="panel panel-primary">
    	<div class="panel-heading">
	        <h3 class="panel-title">
	            	查询
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>上级名称</th><th>添加时间</th><th>操作</th></tr>
		    	<c:forEach var="list"  items="${data}">
		    	<tr>
		    		<td><a href="/web/page.do?account=${list.userId}">${list.name }</a></td>
		    		<td>${list.cardnum }</td>
		    		<td>${list.pName }</td>
		    		<td>${list.createTime }</td>
		    		<td><a href="javascript:delUser('${list.userId }');">删除</a></td>
		    	</tr>
		    	</c:forEach>
		    </table>
	    </div>
    </div>
    
</div>
</body>
</html>