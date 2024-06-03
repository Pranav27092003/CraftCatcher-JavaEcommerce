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
<title>All Handicraft Items</title>
<%@include file = "all_component/allCss.jsp" %>
</head>
<body>
<%@include file = "all_component/navbar.jsp" %>


	<div class="container-fluid">
		<h3 class="text-center">Handicraft Items</h3>
		<div class="row p-3">
		<%
		ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
		List<ItemDtls> list = dao.allHandicrafts();
		for(ItemDtls i: list){		
		%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="" src="images/<%=i.getItemphoto() %>" style="width: 200px; height: 300px"
							class="img-thumblin">
						<p><b><%= i.getItemname() %></b></p>
						<p><b><%= i.getCategory() %></b></p>
						<div class="row ">
							<a href="" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a> <a
								href="" class="btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=i.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
			<%
		     }
			%>			
		</div>

</body>
</html>