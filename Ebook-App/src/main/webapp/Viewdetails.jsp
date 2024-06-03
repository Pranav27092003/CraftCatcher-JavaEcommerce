<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.DAO.ItemDAOImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity.ItemDtls"%>
<%@ page import= "com.entity.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
<style>
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
}
</style>
</head>
<body style = "background-color: #f0f1f2">
	<%@ include file="all_component/navbar.jsp"%>
	
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	ItemDAOImpl dao = new ItemDAOImpl(DBConnect.getConn());
	ItemDtls i = dao.getItemById(id);
	%>

	<%
	User u = (User) session.getAttribute("userobj");
	%>
<c:if test= "${not empty addCart }">
<div id="toast">${addcart }</div>

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
	<div class="container p-3">
		<div class="row p-5">
			<div class="col-md-6 text-center p-5 border bg-white">
			<img src = "images/<%=i.getItemphoto() %>" style  = "height: 300px; width: 250px;">
			<h4 class = "mt-3"> Item name: <span class = "text-success"><%= i.getItemname() %></span> </h4>
			<h4> Category: <span class = "text-success"><%= i.getCategory() %></span></h4>
			</div>
			
			<div class="col-md-6 text-center p-5 border bg-white">
			<h4> <%= i.getItemname() %></h4>
			<div class = "row mt-4">
			<div class = "col-md-4 text-center text-danger p-3">
			<i class = "fas fa-money-bill-wave fa-3x"></i>
			<p> Cash On Delivery</p>
			</div>
			<div class = "col-md-4 text-center text-danger p-3">
			<i class = "fas fa-undo-alt fa-3x"></i>
			<p> Return Available</p>
			</div>
			<div class = "col-md-4 text-center text-danger p-3">
			<i class = "fas fa-truck-moving fa-3x"></i>
			<p> Free Shipping</p>		
			</div>
			</div>
			
			<div class = "text-center p-3">
			
						<% if(u==null){
						%>
						<a href="login.jsp" class="btn btn-primary ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>						
						<%
						}else{
						%>
						<a href="Cart?iid=<%=i.getItemId()%>&uid=<%=u.getId()%>" class="btn btn-primary  ml-4"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>					
						<%
						}					
						%>
			            <a href = "" class = "btn btn-danger"><i class = "fas fa-rupee-sign"></i> <%=i.getPrice() %></a>
			
			</div>
			
			</div>
		</div>
	</div>
</body>
</html>