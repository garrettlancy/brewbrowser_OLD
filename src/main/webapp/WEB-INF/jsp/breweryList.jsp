<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf"%>

<div class="text-center row col-md-12 contain-center">
<div class="container col-md-10 col-md-offset-1">
	<c:forEach var="brewery" items="${breweries}">
		<c:url var="breweryDetailsUrl" value="/breweryDetails">
			<c:param name="breweryId" value="${brewery.breweryId}" />
		</c:url>
		<a href="${breweryDetailsUrl}">
			<div class="col-md-3 text-center">
				<div class="brewery-tile">
					<c:url var="imageUrl" value="/img/breweries/${brewery.imgUrl}" />
					<img src="${imageUrl}" class="img-responsive"><br>
					<div>${brewery.name}</div>
				</div>
			</div>
		</a>
	</c:forEach>
</div>
</div>

<%@ include file="common/footer.jspf"%>