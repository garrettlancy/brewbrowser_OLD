<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>

<div class="container">
	<c:if test="${message != null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${message}" />
		</div>
		<br>
	</c:if>
	<h2>Brewer Account</h2>
	<div class="brewtable">
		<c:if test="${!breweries.isEmpty()}">
			<h3>My Breweries</h3>
			<table class="table">
				<c:forEach var="brewery" items="${breweries}">
					<tr>
						<c:url var="breweryDetailsUrl" value="/breweryDetails">
							<c:param name="breweryId" value="${brewery.breweryId}" />
						</c:url>
						<td><a href="${breweryDetailsUrl}"><c:out
									value="${brewery.name}" /></a></td>
						<c:url var="updateUrl" value="/breweryUpdate" />
						<td><form action="${updateUrl}" method="GET">
								<input type="hidden" name="breweryId"
									value="${brewery.breweryId}"><input type="submit"
									value="Edit Brewery">
							</form></td>
						<c:url var="deleteUrl" value="/deleteBrewery" />
						<td><form action="${deleteUrl}" method="POST">
								<input type="hidden" name="breweryId"
									value="${brewery.breweryId}"><input type="submit"
									value="Delete">
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>
		<form action="${breweryRegisterUrl}">
			<input type="submit" value="Add Brewery">
		</form>
	</div>
</div>

<%@ include file="common/footer.jspf"%>