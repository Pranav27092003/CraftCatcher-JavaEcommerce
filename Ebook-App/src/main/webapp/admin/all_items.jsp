<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.ItemDAOImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.ItemDtls"%>

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
	<%@include file="navbar.jsp"%>
	<c:if test= "${ empty userobj}">
	<c:redirect url = "../login.jsp"></c:redirect>
		</c:if>
	<h3 class="text-center">Hello! Admin</h3>
	<table class="table">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Item Name</th>
				<th scope="col">Item Category</th>
				<th scope="col">Image</th>			
				<th scope="col">Price</th>				
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
			List<ItemDtls> list = dao.getAllItems();
			for (ItemDtls i : list) {
			%>
			<tr>
				<td> <%=i.getItemId()%></td>
				<td><%=i.getItemname()%></td>
				<td><%=i.getCategory()%></td>
				<td><img src="../images/<%=i.getItemphoto()%>"
					style="height: 50px; width: 50px;"></td>
				<td><%=i.getPrice()%></td>
				<td> <a href = "edit_items.jsp?id=<%= i.getItemId() %>" class = "btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a>
					 <a href = "../delete?id=<%= i.getItemId() %>" class = "btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>Delete</a></td>


			</tr>

			<%
			}
			%>



		</tbody>
	</table>

	<%@include file="footer.jsp"%>
</body>
</html>