<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Custom CSS styling for the page -->
<style>
	<%@ include file="../css/form-page.css" %>
</style>

<title>Customer Details Form</title>
</head>

<body>
	<header class="header">
		<h1>Customer Register</h1>
		<hr color="#009879">
	</header>
	
	<!-- custom div class -> "registration-form" -->
	<div class="registration-form">

		<!-- custom header class -> "form-header" -->
		<p class="form-header">Customer details form</p>
		<form action="/customerRelationshipManagement/customers/save" 	method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${customer.id}" />

			<!-- Each text input is preceded by corresponding text the fields can populated existing values to be updated else have 
			a placeholder text in their place-->
			<div>
				<p>First Name</p>
				<input type="text" name="firstName" value="${customer.firstName}" placeholder="First Name">
			</div>
			<div>
				<p>Last Name</p>
				<input type="text" name="lastName" value="${customer.lastName}" placeholder="Last Name">
			</div>
			<!-- This is a required field -->
			<div>
				<p>Email id</p>
				<input type="text" name="email" value="${customer.email}" placeholder="Email id" required>
			</div>
			<!-- Button of type="submit" -->
			<button type="submit" class="save-button">Submit</button>
		</form>
 
		<!-- a link leading back to customer list page -->
		<a href="/customerRelationshipManagement/customers/list">Back to view list of customers</a>
		<hr color="#009879">
	</div>
</body>
</html>