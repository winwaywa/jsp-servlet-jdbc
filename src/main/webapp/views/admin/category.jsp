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
		<div class="d-flex justify-content-end pb-3">
			<a href="<c:url value='admin-category?type=edit'/>" class="btn btn-success mr-2" data-toggle="tooltip" title="Add new category"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			<button id="btnDelete" type="button" class="btn btn-danger" data-toggle="tooltip" title="Delete categories">
				<i class="fa fa-trash" aria-hidden="true"></i>
			</button>
		</div>
		<table class="table mb-5">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Update At</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty model.dataList}">
					<c:forEach items="${model.dataList}" var="item">
						<tr>
							<th  class="align-bottom" scope="row">${item.id}</th>
							<td  class="align-bottom">${item.code}</td>
							<td  class="align-bottom">${item.name}</td>
							<td  class="align-bottom">${item.updatedAt}</td>
							<td>
								<c:url var="editURL" value="/admin-category">
									<c:param name="type" value="edit" />
									<c:param name="id" value="${item.id}" />
								</c:url>
								<a href="${editURL}" class="btn btn-info" data-toggle="tooltip" title="Update category">
								<i class="fas fa-edit"></i>
								</a>
							</td>
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