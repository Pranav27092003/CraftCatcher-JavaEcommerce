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
<title>Admin:Add Items</title>
<%@include file="allCss.jsp"%>
</head>
<body style = "background-color:#f0f2f2">
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<div class="card-body">
						<h4 class="text-center">Edit Items</h4>
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
						ItemDtls i = dao.getItemById(id);
						
						%>
						<form action="../editItems" method="post">
						<input type = "hidden" name = "id" value = "<%= i.getItemId() %>" >
							<div class="form-group">
								<label for="exampleInputEmail1">Item Name</label><input
									name="iname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" value ="<%=i.getItemname() %>">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price</label><input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1" value ="<%=i.getPrice() %>">
							</div>

							<div class="form-group">
								<label for="inputState"> Item Categories</label> <select
									name="category" class="form-control" id="inputState" >
									<% 
									if("Dreamcatchers".equals(i.getCategory())){
									%> 
									<option value="Dreamcatchers">Dreamcatchers</option>
									<option value="Resin Product">Resin Products</option>
									<option value="Handicraft Item">Handicraft Item</option>
									<%}else if("Resin Product".equals(i.getCategory())){
									%> 
									<option value="Resin Product">Resin Products</option>
									<option value="Dreamcatchers">Dreamcatchers</option>									
									<option value="Handicraft Item">Handicraft Item</option>
									<%
									}else{
									%> 
									<option value="Handicraft Item">Handicraft Item</option>
									<option value="Dreamcatchers">Dreamcatchers</option>
									<option value="Resin Product">Resin Products</option>									
									<% 
									}									
									%>	
									</select>								
							   </div>								
							       <button type = "submit" class = "btn btn-primary">Update</button>							
						  </form>					
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<%@include file ="footer.jsp" %>
</body>
</html>