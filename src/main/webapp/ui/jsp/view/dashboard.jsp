<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="appTags" uri="AppTagLib" %>

<div class="row text-center"><strong> User Details</strong></div>
<div class="row" style="border:1px solid green;padding:10px">
    <div class="col-md-4 text-center"><strong>Name</strong></div>
    <div class="col-md-4 text-center"><strong>Email</strong></div>
    <div class="col-md-4 text-center"><strong>Address</strong></div>
</div>
<c:forEach var="user" items="${users}">
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-4 text-center">${user.name} lub ${userNameFormatter.format(user)}</div>
        <div class="col-md-4 text-center">${user.email} ${priceFormatter.getFormattedPrice(user.email)}</div>
        <div class="col-md-4 text-center">${user.address}</div>
    </div>
</c:forEach>

<form:form method="POST" commandName="user">
    <form:input path = "email" /><br/>
    <form:input path = "address" /><br/>
    <form:select  path="name">
        <form:option value="NONE"> --SELECT--</form:option>
        <form:option value="John"> --John--</form:option>
        <form:option value="John2"> --John2--</form:option>
      </form:select>
</form:form>

<spring:message code="page.label" />

<appTags:simpleTag />