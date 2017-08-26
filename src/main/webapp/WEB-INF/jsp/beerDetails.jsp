<%@ include file="common/header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container text-center row contain-center">
	<div class="col-md-6 beer-details">
		<table class="col-md-12 table details-table">
			<thead>
				<tr>
					<th class="text-center" colspan="2">
						<div class="beer-img">
							<c:url var="imageUrl" value="/img/thumbnails/${beer.imgUrl}" />
							<img src="${imageUrl}" class="img-responsive"><br>
						</div>
						<div class="beer-name">
							<c:out value="${beer.name}" />
						</div>
						<div>
							Beer Style:
							<c:out value="${beer.type}" />
						</div>
						<div>
							Alcohol by volume (ABV):
							<c:out value="${beer.alcoholPercentage}" />
						</div>
						<div>
							Average Rating:
							<c:forEach begin="1" end="${beer.avgRating}">
								<i class="fa fa-star inline-block rating" aria-hidden="true"></i>
							</c:forEach>
						</div>
					</th>
				</tr>
				<tr>
					<th>
						<div class="text-center">
							Description:<br>
							<c:out value="${beer.description}" />
						</div>
					</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="reviews col-md-6">
		<h2>${beer.name}Reviews</h2>
		<div class="col-md-12">
			<br>
			<c:forEach var="review" items="${reviews}">
				<div class="col-md-12">
					<table class="table beer-reviews">
						<thead>
							<tr class="beer-reviews">
								<td>Username: <c:out value="${review.username}" />
								<td>
							</tr>
						<thead>
						<tbody>
							<tr>
								<td class="beer-reviews">Rating:</td>
								<td><c:forEach begin="1" end="${review.rating}">
										<i class="fa fa-star inline-block rating" aria-hidden="true"></i>
									</c:forEach></td>
							</tr>
							<tr>
								<td class="beer-reviews">Review:</td>
								<td><c:out value="${review.reviewText}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</div>
		<c:url var="formAction" value="/review" />
		<form:form id="form0" action="${formAction}" method="POST"
			modelAttribute="review">
			<br>
			<div class="col-md-12">
				<div>
					<label for="rating">Select a <i
						class="fa fa-star inline-block rating" aria-hidden="true"></i>
						Rating
					</label><br>
					<form:select path="rating">
						<form:option value="0">Select a Rating</form:option>
						<form:option value="1">1 Star</form:option>
						<form:option value="2">2 Stars</form:option>
						<form:option value="3">3 Stars</form:option>
						<form:option value="4">4 Stars</form:option>
						<form:option value="5">5 Stars</form:option>
					</form:select>
				</div>
				<br>
				<div class="col-md-12">
					<form:textarea path="reviewText" rows="8" cols="40"
						class="textarea review-text" placeholder="Write A Review" />
					<form:errors path="reviewText" cssClass="error" />
				</div>
				<form:input type="hidden" path="beerId" value="${beer.beerId}" />
				<input type="submit" name="action" value="Submit" />

			</div>
		</form:form>
	</div>
</div>


<%@ include file="common/footer.jspf"%>