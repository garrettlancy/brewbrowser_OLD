<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>

<c:if test="${message != null}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${message}" />
	</div>
	<br>
</c:if>
<div class="container">
	<h2>New Beer</h2>
	<c:url var="formAction" value="/addBeer" />
	<form:form id="form0" action="${formAction}" method="POST"
		modelAttribute="beer">

		<div>
			<label for="name">Beer Name</label><br>
			<form:input path="name" class="textbox" placeholder="Enter Beer Name" />
			<form:errors path="name" cssClass="error" />
		</div>
		<br>
		<div>
			<label for="alcoholPercentage">Beer Alcohol Percentage</label><br>
			<form:input class="textbox" path="alcoholPercentage"
				placeholder="0.0%" />
			<form:errors class="textbox" path="alcoholPercentage"
				cssClass="error" />
		</div>
		<br>
		<div>
			<label for="typeId">Beer Style</label><br>
			<form:select path="typeId" class="required">
				<form:option value="0" label="Select a Style" />
				<form:option value="1" label="Stout" />
				<form:option value="2" label="Lager" />
				<form:option value="3" label="IPA" />
				<form:option value="4" label="Dopplebock" />
				<form:option value="5" label="Hefeweizen" />
				<form:option value="6" label="Blonde" />
				<form:option value="7" label="Pilsner" />
				<form:option value="8" label="Pale Ale" />
				<form:option value="9" label="Sour Ale" />
			</form:select>
		</div>
		<br>
		<div>
			<label for="description">Beer Description</label><br>
			<form:textarea class="textarea" path="description" rows="5" cols="80"
				placeholder="Enter Beer Description"></form:textarea>
			<form:errors path="description" cssClass="error" />
		</div>
		<br>

		<input type="hidden" name="breweryId" value="${breweryId}">
		<input type="submit" name="action" value="Add Beer" />
	</form:form>
	<br> <br>
	<div>
		<c:url var="breweryUpdateUrl" value="/breweryUpdate">
			<c:param name="breweryId" value="${breweryId}" />
		</c:url>
		<a href="${breweryUpdateUrl}"><button type="button"
				class="cancelbtn">Cancel</button></a>
	</div>
</div>

<%@ include file="common/footer.jspf"%>