<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您好</title>
</head>
<body>
<h1>用户添加</h1>
<form:form method="POST" commandName="user" cssClass="form-horizontal">
	<div class="control-group">
		<label class="control-label" for="userId">账号</label>
		<div class="controls">
			<form:input path="userId" />
			<form:errors path="userId" cssClass="text-error" element="label"/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="userPsd">密码</label>
		<div class="controls">
			<form:password path="userPsd" />
			<form:errors path="userPsd" cssClass="text-error" element="label"/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="userGroup">用户组</label>
		<div class="controls">
			<form:input path="userGroup" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="userNm">用户名</label>
		<div class="controls">
			<form:input path="userNm" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="email">电子邮箱</label>
		<div class="controls">
			<form:input path="email" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="phoneNum">电话</label>
		<div class="controls">
			<form:input path="phoneNum" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="address">地址</label>
		<div class="controls">
			<form:input path="address" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="zipCd">邮编</label>
		<div class="controls">
			<form:input path="zipCd" />
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<input type="button" name="approve" class="btn btn-primary" value="创建" onclick="addUser();"/>
			<input type="button" name="cancel" class="btn " value="取消" onclick="cancelAdd();"/>
		</div>
	</div>	
</form:form>
<script type="text/javascript">
var menuId = "userId";
function addUser(){
	$("#user").attr("action", "/yulongnews/user/add");
	$("#user").submit();
}
function cancelAdd(){
	$("#user").attr("action", "/yulongnews/user/list");
	$("#user").submit();
}
</script>
</body>
</html>