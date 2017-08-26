<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>

<div class="container">
	<c:if test="${message != null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${message}" />
		</div>
		<br>
	</c:if>
</div>
<div id="register" class="container">
	<h2>User Registration</h2>
	<br>
	<c:url var="formAction" value="/register" />
	<form:form id="form0" action="${formAction}" method="POST"
		modelAttribute="user">
		<div>
			<label for="email">Email</label><br>
			<form:input path="email" placeholder="Email Address" class="textbox" />
			<form:errors path="email" cssClass="error" />
		</div>
		<br>
		<div>
			<label for="username">Username</label><br>
			<form:input path="username" placeholder="Username" class="textbox" />
			<form:errors path="username" cssClass="error" />
		</div>
		<br>
		<div>
			<label for="password">Password</label><br>
			<form:input path="password" placeholder="Password" type="password"
				class="textbox" />
			<form:errors path="password" cssClass="error" />
		</div>
		<br>
		<div>
			<label for="confirmPassword">Confirm Password</label><br>
			<form:input path="confirmPassword" placeholder="Confirm Password"
				type="password" class="textbox" />
			<form:errors path="confirmPassword" cssClass="error" />
			<form:errors path="passwordMatching" cssClass="error" />
		</div>
		<br>
		<input type="submit" name="action" value="Register" />
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>
