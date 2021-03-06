<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<spring:url value="/style.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Psallas Apostolos</title>
		<c:choose>
					<c:when test = "${empty loggedInUser.userName}">
							<c:redirect url = "index"/>
					</c:when>
					
					</c:choose>
					
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
				<li><a href='experience'>Experience</a></li>
				<li><a href='education'>Education</a></li>
				<li><a href='index'>Home</a></li>
			</ul>
			<br><br><br><br>
				<h2>Edit education page</h2>
				<form method="POST" action="/resume/editEducation">
					<table>
						
						<tr>
							<td>
								<label>Text</label>
							</td>
							<td>
								 <textarea rows="10" cols="50" name="text">
									${text}
								</textarea> 
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button submit>submit</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
