<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Profile!</h1>

<p>
	Id: ${profile.id} <br>
	Firstname: ${profile.firstName} <br>
	Lastname: ${profile.lastName} <br>
	E-Mail: ${profile.email} <br>
	Teamname: ${profile.teamName} <br>
</p>

<c:import url="template/footer.jsp" />