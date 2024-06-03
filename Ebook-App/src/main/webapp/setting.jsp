<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.ItemDAOImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.ItemDtls"%>
<%@ page import="com.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Setting Page</title>
<%@include file="all_component/allCss.jsp"%>

<style type="text/css">

a{

text-decoration:none;
color:black;
}

a:hover{
text-decoration:none;
}
</style>
</head>
<body class="background-color: #f0f1f2;">
<c:if test="${empty userobj}">
   <c:redirect url= "login.jsp"/>
</c:if>
<
<%
User u = (User) session.getAttribute("userobj");
%>
<%@include file="all_component/navbar.jsp"%>

	<div class="container">
	
	<c:if test="${not empty userobj }">
	<h3 class = "text-center"> Hello, ${userobj.name}</h3>
	</c:if>
	
		<div class="row p-5">
			<div class="col-md-6">
				<a href = "editprofile.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class = "text-primary">
					<i class="fa-solid fa-address-card fa-3x"></i>
					</div>
					<h3>Login & Security</h3>	
					<h5>Edit Profile</h5>				
					</div>
				</div>
				</a>
			</div>	
			
			<div class="col-md-6">
				<a href = "order.jsp">
				<div class="card">
					<div class="card-body text-center bg-white">
					<div class = "text-danger">
					<i class="fa-solid fa-box-open fa-3x"></i>
					</div>
					<h3>Your Order</h3>
					<h5>Track your order</h5>					
					</div>
				</div>
				</a>
			</div>		
	  </div>
	  
		<div class="row p-5">		
			
			<div class="col-md-6 offset-md-3">
				<a href = "helpline.jsp">
				<div class="card">
					<div class="card-body text-center bg-white">
					<div class = "text-primary">
					<i class="fa-solid fa-circle-user fa-3x"></i>
					</div>
					<h3>Help Center</h3>
					<h5>24*7 Service</h5>					
					</div>
				</div>
				</a>
			</div>		
		
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>