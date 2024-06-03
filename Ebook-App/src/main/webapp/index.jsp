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
<title>Home Page</title>
<%@include file="all_component/allCss.jsp"%>
 
<style type="text/css">
.back-img {
	background: url("img/head1.jpg");
	height: 60vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat
}

.crd-ho:hover {
	background-color: #fcf7f7;
}

.crd-ho{
height: 500px;
}

.head1{
  width : 100%
}

.dreamcatcher{
  margin-top: 50px;
  margin-left: 400px;
  margin-bottom: 50px;
}

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
</style>
</head>
<body style="background-image: url('peach.jpg');">

<%
User u = (User) session.getAttribute("userobj");
%>


<c:if test= "${not empty addcart}">
<div id="toast">${addcart}</div>

<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>


</c:if>

	<%@include file="all_component/navbar.jsp"%>
	<div>
	<img src = "img/head1.jpg" class = "head1">
	</div>
	
	<!-- Dreamcatchers section begin -->
	
	<div class="container-fluid">
		<img src = "img/dc3.jpg" class = "dreamcatcher">
		<div class="row">
		<%
		ItemDAOImpl da = new ItemDAOImpl(DBConnect.getConn());
		List<ItemDtls> lis = da.getDreamCatchers();
		for(ItemDtls i: lis){		
		%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="images/<%=i.getItemphoto()%>" style="width: 200px; height: 300px"
							class="img-thumblin">
						<p><b><%= i.getItemname() %></b></p>
						<p><b><%= i.getCategory() %></b></p>
						<div class="row ">
						<% if(u==null){
						%>
						<a href="login.jsp" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>						
						<%
						}else{
						%>
						<a href="Cart?iid=<%=i.getItemId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>					
						<%
						}					
						%>
						<a	href="Viewdetails.jsp?id=<%=i.getItemId() %>" class="btn btn-success btn-sm ml-1">View Details</a> 
						<h4>&nbsp;<i class="fa-solid fa-indian-rupee-sign"><%=i.getPrice() %></i></h4>
						</div>
					</div>
				</div>
			</div>
			<%
		     }
			%>			
		</div>
		<div class="text-center mt-2">
			<a href="all_dreamcatchers.jsp" class="btn btn-danger btn-sm">View All</a>
		</div>
	</div>

	<!-- End of Dreamcatchers -->
		
		<!-- Resin product section begin -->
	<div class="container-fluid">
		<img src = "img/res.jpg" class = "dreamcatcher">
		<div class="row">		
		<%
		ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
		List<ItemDtls> list = dao.getResinProduct();
		for(ItemDtls i: list){		
		%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="images/<%= i.getItemphoto() %>" style="width: 200px; height: 300px" class="img-thumblin">
						<p><b><%=i.getItemname() %></b></p>
						<p><b><%=i.getCategory() %></b></p>
						<div class="row ">
						<% if(u==null){
						%>
						<a href="login.jsp" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>						
						<%
						}else{
						%>
						<a href="Cart?iid=<%=i.getItemId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>					
						<%
						}					
						%>
							 <a	href="Viewdetails.jsp?id=<%=i.getItemId() %>" class="btn btn-success btn-sm ml-1">View Details</a> 
							 <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%= i.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
			<%
		     }
			%>
		</div>	
			
		<div class="text-center mt-2">
			<a href="all_resinproduct.jsp" class="btn btn-danger btn-sm ">View All</a>
		</div>
	</div>

	<!-- End of Resin Products -->
	
	<!-- Handicrafts Item  Section begin Here -->
	
	<div class="container-fluid">
		<h3 class="text-center">Handicraft Items</h3>
		<div class="row">		
		<%
		ItemDAOImpl d = new ItemDAOImpl(DBConnect.getConn());
		List<ItemDtls> li = d.getHandicraftItems();
		for(ItemDtls i: li){		
		%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="images/<%= i.getItemphoto() %>" style="width: 200px; height: 300px" class="img-thumblin">
						<p><b><%=i.getItemname()  %></b></p>
						<p><b><%=i.getCategory()  %></b></p>
						<div class="row ">
						<% if(u==null){
						%>
						<a href="login.jsp" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>						
						<%
						}else{
						%>
						<a href="Cart?iid=<%=i.getItemId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>					
						<%
						}					
						%>
							 <a href="Viewdetails.jsp?id=<%=i.getItemId() %>" class="btn btn-success btn-sm ml-1">View Details</a> 
							 <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%= i.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
			<%
		     }
			%>
		</div>	
			
		<div class="text-center mt-2">
			<a href="all_handicrafts.jsp" class="btn btn-danger btn-sm ">View All</a>
		</div>
	</div>

	<!-- End of handicrafts -->
	
	
	
	
	<%@include file="all_component/footer.jsp" %>
</body>
</html>
