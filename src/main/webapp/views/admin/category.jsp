<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Update At</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty model.dataList}">
					<c:forEach items="${model.dataList}" var="category">
						<tr>
							<th scope="row">${category.id}</th>
							<td>${category.code}</td>
							<td>${category.name}</td>
							<td>${category.updatedAt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div class="row">
			<div class="col-12">
				<div id="pagination" class="text-center"></div>
			</div>
		</div>
		<form action="<c:url value='/admin-category'/>" id="formSubmit"
			method="GET">
			<input type="hidden" name="page" value="" id="page">
			<input type="hidden" name="maxPageItem" value="" id="maxPageItem">
			<input type="hidden" name="sortName" value="" id="sortName">
			<input type="hidden" name="sortValue" value="" id="sortValue">
		</form>
	</div>
	<script>
		let totalPages = ${model.totalPages};
		let currentPage = ${model.page};
		let maxPageItem = ${model.maxPageItem};
		let sortName = '${model.sortName}';
		let sortValue = '${model.sortValue}';
		let maxButtonsVisible = 3;

		$(document).ready(function() {
			var pag = $('#pagination').simplePaginator({
				totalPages : totalPages,
				maxButtonsVisible : maxButtonsVisible,
				currentPage : currentPage,
				pageChange : function(page) {
					console.log(page);
					if (currentPage != page) {
						$("#page").val(page);
						$("#maxPageItem").val(maxPageItem);
						$("#sortName").val(sortName);
						$("#sortValue").val(sortValue);
						$("#formSubmit").submit();
					}
				}
			});
			$('#changeTotalPages').click(function() {
				pag.simplePaginator('setTotalPages', 10);
			})

			$('#changePage').click(function() {
				pag.simplePaginator('changePage', 3);
			})

			$('#hide').click(function() {
				pag.simplePaginator('hide');
			})
		});
	</script>

</body>
</html>