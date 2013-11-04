<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<h1>用户列表</h1>
<form:form method="POST" commandName="userForm" cssClass="form-horizontal">
	<input type="hidden" name="id" id="userIdAsId"/>
	<table class="table">
		<thead>
			<tr>
				<th></th>
				<th>账号</th>
				<th>用户名</th>
				<th>用户组</th>
				<th>电子邮箱</th>
				<th>电话</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items='${users}'>
			<tr>
				<td></td>
				<td>${user.userId}</td>
				<td>${user.userGroup}</td>
				<td>${user.userNm}</td>
				<td>${user.email}</td>
				<td>${user.phoneNum}</td>
				<td>
					<input type="button" name="approve" class="btn btn-primary" value="编辑" onclick="edit(${user.id});"/>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="control-group">
		<div class="controls">
			<input type="button" name="approve" class="btn btn-primary" value="创建" onclick="addUser();"/>
		</div>
	</div>	
</form:form>
<script type="text/javascript">
var menuId = "userId";
function edit(id){
	$("#userIdAsId").val(id);
	$("#userForm").attr("action", "/yulongnews/user/edit");
	$("#userForm").submit();
}
function addUser(){
	window.location.href = "/yulongnews/user/showAdd";
}
</script>
</body>
</html>