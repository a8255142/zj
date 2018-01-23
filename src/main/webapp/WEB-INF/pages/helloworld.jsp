<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
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
	<div class="panel panel-primary">
		<div class="panel-heading">
	        <h3 class="panel-title">
	            	添加用户
	        </h3>
	    </div>
		<form id="frm">
			<table class="table table-bordered table-striped table-condensed">
				<tr>
					<td>上级身份证：</td>
					<td><input type="text" name="pCardnum" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="name" name="name" /></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><input type="text" id="cardnum" name="cardnum" /></td>
				</tr>
				<tr>
					<td style="text-align: center;"><a href="javascript:sub();">提交</a></td>
					<td style="text-align: center;"><a href="javascript:$('#frm')[0].reset();">清空</a></td>
				</tr>
			</table>
		</form>
	</div>
	<form id="frm1" action="page.do" method="get"  class="navbar-form" >
		<div  class="form-group">
			<span>身份证或者姓名：</span><input type="text" id="account" value="${param.account }" name="account"  class="form-control" placeholder="Search" />
			<input  type="submit"  class="btn btn-default"  value="查询">
			<input  type="button"  class="btn btn-default" onclick="location.href='allUser.do'" value="返回">
		</div>	
	</form>
	
	<div class="panel panel-primary">
       <div class="panel-heading">
	        <h3 class="panel-title">
	            	当前查询
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>操作</th></tr>
		    	 <c:if test="${!empty data.nowUser}">
			    	<td><a href="/web/page.do?account=${data.nowUser.userId}">${data.nowUser.name}</a></td>
			    	<td>${data.nowUser.cardnum}</td>
			    	<td>
			    		<a href="javascript:show('${data.nowUser.userId }','${data.nowUser.name }','${data.nowUser.cardnum }');">修改</a>
			    		<a href="javascript:delUser('${data.nowUser.userId }');">删除</a>
			    	</td>
			      </c:if>
		    </table>
		</div>
	</div>
	
    <div class="panel panel-primary">
       <div class="panel-heading">
	        <h3 class="panel-title">
	            	上级
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>操作</th></tr>
		    	 <c:if test="${!empty data.pUser}">
			    	<td><a href="/web/page.do?account=${data.pUser.userId}">${data.pUser.name}</a></td>
			    	<td>${data.pUser.cardnum}</td>
			    	<td>
			    		<a href="javascript:show('${data.pUser.userId }','${data.pUser.name }','${data.pUser.cardnum }');">修改</a>
			    		<a href="javascript:delUser('${data.pUser.userId }');">删除</a>
			    	</td>
			      </c:if>
		    </table>
		</div>
    </div>
    
    <div class="panel panel-primary">
    	<div class="panel-heading">
	        <h3 class="panel-title">
	            	一级
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>操作</th></tr>
		    	<c:forEach var="list"  items="${data.childList}">
		    	<tr>
		    		<td><a href="/web/page.do?account=${list.userId}">${list.name }</a></td>
		    		<td>${list.cardnum }</td>
		    		<td>
		    			<a href="javascript:show('${list.userId }','${list.name }','${list.cardnum }');">修改</a>
		    			<a href="javascript:delUser('${list.userId }');">删除</a>
		    		</td>
		    	</tr>
		    	</c:forEach>
		    </table>
	    </div>
    </div>
    
    <div class="panel panel-primary">
    	<div class="panel-heading">
	        <h3 class="panel-title">
	            	二级
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>操作</th></tr>
		    	<c:forEach var="list"  items="${data.childList1}">
		    	<tr>
		    		<td><a href="/web/page.do?account=${list.userId}">${list.name }</a></td>
		    		<td>${list.cardnum }</td>
		    		<td>
		    			<a href="javascript:show('${list.userId }','${list.name }','${list.cardnum }');">修改</a>
		    			<a href="javascript:delUser('${list.userId }');">删除</a>
		    		</td>
		    	</tr>
		    	</c:forEach>
		    </table>
	    </div>
    </div>
    
    <div class="panel panel-primary">
    	<div class="panel-heading">
	        <h3 class="panel-title">
	            	三级
	        </h3>
	    </div>
	    <div class="panel-body">
		    <table class="table table-bordered table-striped table-condensed">
		    	<tr><th>姓名</th><th>身份证</th><th>操作</th></tr>
		    	<c:forEach var="list"  items="${data.childList2}">
		    	<tr>
		    		<td><a href="/web/page.do?account=${list.userId}">${list.name }</a></td>
		    		<td>${list.cardnum }</td>
		    		<td>
		    			<a href="javascript:show('${list.userId }','${list.name }','${list.cardnum }');" >修改</a>
		    			<a href="javascript:delUser('${list.userId }');">删除</a>
		    		</td>
		    	</tr>
		    	</c:forEach>
		    </table>
	    </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改
				</h4>
			</div>
			<div class="modal-body">
				<form id="miffrm">
				<input type="hidden" id= "upUserId" name = "userId" />
				<table class="table table-bordered table-striped table-condensed">
					<tr>
						<td>上级身份证：</td>
						<td><input type="text" name="pCardnum" /></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" id="upName" name="name" /></td>
					</tr>
					<tr>
						<td>身份证：</td>
						<td><input type="text" id="upCardnum" name="cardnum" /></td>
					</tr>
				</table>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="updateUser()">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
   function show(id,name,card){
	   $('#myModal').modal('show'); 
	   $("#upUserId").val(id);
	   $("#upName").val(name);
		$("#upCardnum").val(card);
   }
   
</script>
</body>
</html>