<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jspf"%>

<div class="container" id="register">
	<c:choose>
		<c:when
			test="${message.equals('You have successfully registered your account. Please log in to confirm.')}">
			<div class="alert alert-success" role="alert">
				<c:out value="${message}" />
			</div>
			<br>
		</c:when>
		<c:when
			test="${message.equals('Your username or password is incorrect.') || message.equals('Please log in first.')}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${message}" />
			</div>
			<br>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<h2>Login</h2>
	<c:url value="/login" var="loginUrl" />
	<form action="${loginUrl}" method="POST">
		<br>
		<label><b>Username</b></label><br> <input type="text"
			class="textbox" placeholder="Enter Username" name="username" required>
		<br>
		<br> <label><b>Password</b></label><br> <input
			type="password" class="textbox" placeholder="Enter Password"
			name="password" required> <br>
		<br>
		<button type="submit">Login</button>
		<br> <br>
		<div>
			<a href="${homeUrl}"><button type="button" class="cancelbtn">Cancel</button></a>
		</div>

	</form>
</div>

<%@ include file="common/footer.jspf"%>