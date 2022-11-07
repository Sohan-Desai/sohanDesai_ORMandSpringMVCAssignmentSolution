<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=deivice-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
	<%@ include file="../css/list-page.css" %>
</style>
<title>Customers List Page</title>
</head>

<body>
	<header class="header">
		<h1>Customer Register</h1>
		<hr color="#009879">
	</header>
	
	<div class="block1">
		<!-- Add a button "Add Customer" -->
		<a href="/customerRelationshipManagement/customers/showFormForAdd"
			class="addCustomer-button">Add Customer</a> <br />
		<br />
		<!-- custom table class -->
		<table class="custom-table">
			<thead>
				<!-- Table-header row -->
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email id</th>
					<th style="text-align:center">Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstName}" /></td>
						<td><c:out value="${customer.lastName}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td style="text-align:center">
							<!-- Add "Update" button/link --> 
							<a href="/customerRelationshipManagement/customers/showFormForUpdate?customerId=${customer.id}" class="update-button"> Update</a> 
							<!-- Add "Delete button/link which asks for confirmation whether to proceed with delete operation -->
							<a href="/customerRelationshipManagement/customers/delete?customerId=${customer.id}" class="delete-button"
							onclick="if(!(confirm('Are you sure you want to delete ${customer.firstName}?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>