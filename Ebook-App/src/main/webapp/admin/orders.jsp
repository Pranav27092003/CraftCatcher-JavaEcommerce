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
<title>Admin: All Items</title>
<%@include file="allCss.jsp"%>
</head>
<body>
<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello! Admin</h3>

	<table class="table">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">OrderId</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No.</th>
				<th scope="col">Item Name</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
		
		<%
           User u = (User) session.getAttribute("userobj");
		   ItemOrderDAOImpl dao =  new ItemOrderDAOImpl(DBConnect.getConn());		   
		   List<ItemOrder> ilist =dao.getAllOrder();
		   for(ItemOrder i:ilist){%>
			   <tr>
				<th scope="row"><%=i.getOrderid() %></th>
				<td><%=i.getUsername() %></td>
				<td><%=i.getEmail() %></td>
				<td><%=i.getFullAddress()%></td>
				<td><%=i.getItemname() %></td>
				<td><%=i.getPrice() %></td>
				<td><%=i.getPaymentType() %></td>				
			</tr>
		   <%}
           %>   
			
			
		</tbody>
	</table>
	
	<%@include file ="footer.jsp" %>
</body>
</html>