<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Address Page</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-primary">Your Address</h4>

						<form>
							<div class="form-row p-2">
								
								<div class="form-group col-md-6">
									<label for="inputaddress4">Address</label> <input type="text"
										class="form-control" id="inputaddress4">
								</div>
								
								<div class="form-group col-md-6">
									<label for="inputlandmark4">Landmark</label> <input type="text"
										class="form-control" id="inputlandmark4">
								</div>
							</div>
							<div class="form-row p-2">
								
								<div class="form-group col-md-4">
									<label for="inputCity4">City</label> <input type="text"
										class="form-control" id="inputCity4">
								</div>
								<div class="form-group col-md-4">
									<label for="inputState4">State</label> <input type="text"
										class="form-control" id="inputState4">
								</div>
								
								<div class="form-group col-md-4">
									<label for="inputPin4">Pin Code</label> <input type="number"
										class="form-control" id="inputPin4">
								</div>
							</div>
							
							<div class="text-center">								
								<a href="" class="btn btn-warning">Add Address</a>
							</div>

						</form>
						
					
					</div>
				</div>
			</div>
		</div>
	</div>

<br><br><br>
 <%@include file="all_component/footer.jsp"%>
	
</body>
</html>