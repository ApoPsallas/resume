<%-- 
    Document   : index
    Created on : May 29, 2017, 9:20:02 PM
    Author     : Apostolis
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Psallas Apostolos</title>
</head>
<body>
	<div id="wrapper">
		<div id="content">
			<ul id="nav">
				<div class="logo">
					<li>Apostolos Psallas</li>
				</div>
				<li><a href='contact'>Contact</a></li>
				<li><a href='personalInfo'>Personal Information</a></li>
				<li><a href='interests'>Interests</a></li>
				<li class='active'><a href='experience'>Experience</a></li>
				<li><a href='education'>Education</a></li>
				<li><a href='index'>Home</a></li>
			</ul>

			<br><br><br><br>
			<c:choose>
				<c:when test="${empty loggedInUser.userName}">
				</c:when>
				<c:otherwise>
						hello ${loggedInUser.userName} <a href="logout">Log Out</a>
					<br>
					<a href="editExperience">Edit page</a>
				</c:otherwise>
			</c:choose>

			<center>
				<div id="text">${text}</div>
			</center>
		</div>
	</div>
</body>
</html>
