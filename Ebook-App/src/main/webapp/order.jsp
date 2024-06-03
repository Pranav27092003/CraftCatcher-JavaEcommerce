<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.ItemOrderDAOImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.ItemOrder"%>
<%@ page import="com.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordered Items</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	<%@include file="all_component/navbar.jsp"%>
	<div class = "container">
		<h3 class ="text-center">Your Order</h3>
	<table class="table table-striped mt-3 ">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">OrderId</th>
				<th scope="col">Username</th>
				<th scope="col">Item Name</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
			<%
           User u = (User) session.getAttribute("userobj");
		   ItemOrderDAOImpl dao =  new ItemOrderDAOImpl(DBConnect.getConn());
		   List<ItemOrder> ilist = dao.getItem(u.getEmail());
		   for(ItemOrder i:ilist){%>
			   <tr>
				<th scope="row"><%=i.getOrderid() %></th>
				<td><%=i.getUsername() %></td>
				<td><%=i.getItemname() %></td>
				<td><%=i.getPrice() %></td>
				<td><%=i.getPaymentType() %></td>				
			</tr>
		   <%}
           %>
			
			
		</tbody>
	</table>
	
	</div>


	
</body>
</html>