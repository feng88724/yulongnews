<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%= request.getContextPath() %>/public/css/bootstrap.min.css" rel="stylesheet"/>
<link href="<%= request.getContextPath() %>/public/css/docs.css" rel="stylesheet"/>
<link href="<%= request.getContextPath() %>/public/css/jquery-ui-1.10.0.custom.css" rel="stylesheet"/>
<link href="<%= request.getContextPath() %>/public/css/jquery-ui-1.10.0.ie.css" rel="stylesheet"/>
<link href="<%= request.getContextPath() %>/public/css/font-awesome.min.css" rel="stylesheet"/>
<link href="<%= request.getContextPath() %>/public/css/font-awesome-ie7.min.css" rel="stylesheet"/>


<!-- Load JS here for greater good =============================-->
<script src="<%= request.getContextPath() %>/public/js/jquery-1.8.2.min.js"></script>
<script src="<%= request.getContextPath() %>/public/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/public/js/docs.js"></script>
<script src="<%= request.getContextPath() %>/public/js/jquery.validate.js"></script>
<title>
	<decorator:title/>
</title>
</head>
<body data-target=".bs-docs-sidebar" data-spy="scroll" style="margin: 0; padding: 0;">
	<header id="overview" class="jumbotron subhead">
		<div class="container">
			<h1>誉隆网页</h1>
		</div>
	</header>
	<div class="container" style="min-height: 600px; height: auto;">
    	<div class="row">
			<div class="span3 bs-docs-sidebar">
		    	<ul class="nav nav-list bs-docs-sidenav affix-top">
		        	<li id="userId"><a href="/yulongnews/user/getList"><i class="icon-chevron-right"></i>用户管理</a></li>
		          	<li id="newsId"><a href="/yulongnews/news/getList"><i class="icon-chevron-right"></i>发布新闻</a></li>
		          	<li id="verifyId"><a href="/yulongnews/news/getList"><i class="icon-chevron-right"></i>新闻审核</a></li>
				</ul>
			</div>
	      	<div class="span9">
				<c:if test="${FAIL_MSG != null }">
	      			<div class="alert alert-error" style="margin-bottom: 0px;width:910px;">
				    	<button type="button" class="close" data-dismiss="alert">&times;</button>
				    	<h4>错误!</h4>${FAIL_MSG}
				  	</div>
				</c:if>  
	      		<c:if test="${SUCC_MSG != null}">
			        <div class="alert alert-success">
			    		<button type="button" class="close" data-dismiss="alert">&times;</button>
			    		${SUCC_MSG}
			  		</div>
		  		</c:if>
	      		<decorator:body/>
	      	</div>
      	</div>
	</div>
	<footer class="footer">
		<div class="container">
			<div style="font-size: 12px; line-height: 36px;">© 2013 subaonet.com - 版权所有</div>	
		</div>
	</footer>
<script type="text/javascript">
$(document).ready(function(){
	$("ul.nav li").each(function(){
		if($(this).attr("id") == menuId){
			$(this).addClass("active");
		}else{
			$(this).removeClass("active");
		}
	});
});
</script>
</body>
</html>