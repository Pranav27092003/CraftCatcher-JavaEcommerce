<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.CartDAOImpl"%>
<%@ page import="com.DAO.CartDAO"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.Cart"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center" role="alert">${succMsg}</div>
		<c:remove var="succMsg" scope="session"></c:remove>

	</c:if>



	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger text-center" role="alert">${failedMsg}</div>
		<c:remove var="failedMsg" scope="session"></c:remove>

	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="card mt-4 ">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Items</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Item Name</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>
							<%							
						    User u = (User)session.getAttribute("userobj");								
							CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
				            List<Cart> cart= dao.getItemByUser(u.getId());
				            double totalprice =0.00;
				            for(Cart c: cart)
				            {
				              totalprice = c.getTotalprice();
				            %>
								<tr>
									<th scope="row"><%=c.getItemName()%></th>
									<td><%=c.getPrice() %></td>
									<td><a href="removeItem?iid=<%=c.getIid()%>&uid=<%=c.getUid()%>&cid=<%=c.getCid()%>" class="btn btn-sm btn-danger">Remove</a></td>
								</tr>


								<%
								}
							
							%>

								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><i class="fa-solid fa-indian-rupee-sign"></i><%=totalprice %>
								</tr>


							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card mt-4">
					<div class="card body">
						<h3 class="text-center text-success">Your details for order</h3>
						<form action = "order" method = "post">
						<input type = "hidden" value = "${userobj.id }" name = "id">
						
							<div class="form-row p-2">
								<div class="form-group col-md-6">
									<label for="inputname4">Name</label> <input type="text"
										class="form-control" id="inputname4" value="<%=u.getName()%>" name = "username" required = "required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputEmail4">Email</label> <input type="email"
										class="form-control" id="inputEmail4" value="<%=u.getEmail() %>" name = "email" required = "required">
								</div>
							</div>

							<div class="form-row p-2">
								<div class="form-group col-md-6">
									<label for="inputNumber4">Mobile No.</label> <input
										type="number" class="form-control" id="inputNumber4"
										value="<%= u.getPhno() %>" name = "phno" required = "required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputaddress4">Address</label> <input type="text"
										class="form-control" id="inputaddress4" name = "address" required = "required">
								</div>
							</div>
							<div class="form-row p-2">
								<div class="form-group col-md-6">
									<label for="inputlandmark4">Landmark</label> <input type="text"
										class="form-control" id="inputlandmark4" name = "landmark" required = "required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputCity4">City</label> <input type="text"
										class="form-control" id="inputCity4" name = "city" required = "required">
								</div>
							</div>

							<div class="form-row p-2">
								<div class="form-group col-md-6">
									<label for="inputState4">State</label> <input type="text"
										class="form-control" id="inputState4" name = "state" required = "required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPin4">Pin Code</label> <input type="number"
										class="form-control" id="inputPin4" name = "pincode" required = "required">
								</div>
							</div>

							<div class="form-group p-2">
								<label class="ml-2">Payment Mode</label> <select
									class="form-control" name = "payment">
									<option value = "noselect">---Select---</option>
									<option value = "COD">Cash On Delivery</option>
									
								</select>

							</div>


							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue Shopping</a>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>