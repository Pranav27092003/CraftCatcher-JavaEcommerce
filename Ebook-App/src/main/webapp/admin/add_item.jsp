
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Add Items</title>
<%@include file="allCss.jsp"%>
</head>
<body style = "background-color:#f0f2f2">
	<%@include file="navbar.jsp"%>
	<c:if test= "${ empty userobj}">
	<c:redirect url = "../login.jsp"></c:redirect>
		</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<div class="card-body">
						<h4 class="text-center">Add Items</h4>
						
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session"/>
						</c:if>
						
						<c:if test="${not empty failedMsg }">
							<p class="text-center text-danger">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session"/>
						</c:if>
						<form action="../add_item" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputEmail1">Item Name</label><input
									name="iname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price</label><input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1">
							</div>

							<div class="form-group">
								<label for="inputState"> Item Categories</label> <select
									name="category" class="form-control" id="inputState">
									<option selected>--Select---</option>
									<option value="Dreamcatchers">Dreamcatchers</option>
									<option value="Resin Product">Resin Products</option>
									<option value="Handicraft Item">Handicraft Item</option>
							</div>
							
							
							<div class="form-group">
							<br><br>
								<label for="exampleFormControlFile1">Upload Photo </label> <input
									name="iimg" type="file" class="form-control-file mt-2"
									id="exampleFormControlFile1">
							</div>
							
							<button type = "submit" class = "btn btn-primary">ADD</button>

						</form>

					</div>
				</div>

			</div>
		</div>
	</div>
	
	<%@include file ="footer.jsp" %>
</body>
</html>