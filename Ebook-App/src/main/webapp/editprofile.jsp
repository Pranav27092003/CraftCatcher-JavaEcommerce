<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit profile Page</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-primary">Edit Profile</h4>

					<c:if test ="${not empty failMsg }">
					<h5 class = "text-center text-danger">${failMsg}</h5>
					<c:remove var="failedMsg" scope = "session"/>
					</c:if>
					
					<c:if test ="${not empty succMsg }">
					<h5 class = "text-center text-success">${succMsg}</h5>
					<c:remove var="succMsg" scope = "session"/>
					</c:if>
					
					
						<form action="updateprofile" method="post">
						    <input type = "hidden" value = "${userobj.id}" name = "id">
							<div class="form-group">
								<label for="exampleInputEmail1">Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname" value = "${userobj.name}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email" value  = "${userobj.email}">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phno" value = "${userobj.phno}">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							
							<div class = "text-center p-2">
							<button type="submit" class="btn btn-primary btn-block btn-sm mt-2">Update</button>
							</div>
							
						</form>
					
					
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@include file="all_component/footer.jsp"%>
</body>
</html>