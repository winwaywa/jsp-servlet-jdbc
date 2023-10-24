<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="APIurl" value="/api-admin-category" />
<c:url var="CategoryUrl" value="/admin-category" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>

</head>
<body>
	<section class="container">

		<form id="formSubmit">
			<div class="form-group">
				<label for="inputCode">Category Code</label> <input type="text"
					name="code" class="form-control" id="inputCode"
					placeholder="Enter code" value="${model.code}">
			</div>
			<div class="form-group">
				<label for="inputName">Category Name</label> <input type="text"
					name="name" class="form-control" id="inputName"
					placeholder="Enter name" value="${model.name}">

				<div id="editor">
					<p>This is some sample content.</p>
				</div>

			</div>
			<c:if test="${not empty model}">
				<button id="btnUpdate" type="submit" class="btn btn-primary">Update</button>
				<input type="hidden" name="id" value="${model.id}" id="id">
			</c:if>
			<c:if test="${empty model}">
				<button id="btnAdd" type="submit" class="btn btn-primary">Add</button>
			</c:if>
		</form>
	</section>

	<script type="text/javascript">
		$(document).ready(function() {
			ClassicEditor
            .create( document.querySelector( '#editor' ) ).catch( error => {
                console.error( error );
            } );
		});

		function handleCallAPI(e, method) {
			e.preventDefault();
			var formData = $("#formSubmit").serializeArray();

			var data = {};
			$.each(formData, function(index, item) {
				data[item.name] = item.value;
			})

			$.ajax({
				url : '${APIurl}',
				type : method,
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(result) {
					if(method==="POST"){
						window.location.href = "${CategoryUrl}?type=list&message=insert_success";
					}else if(method==="PUT"){
						window.location.href = "${CategoryUrl}?type=list&message=update_success";
					}
				},
				error : function(err) {
					if(method==="POST"){
						window.location.href = "${CategoryUrl}?type=list&message=insert_fail";
					}else if(method==="PUT"){
						window.location.href = "${CategoryUrl}?type=list&message=update_fail";
					}
				}
			});

		}

		$("#btnAdd").click(function(e) {
			handleCallAPI(e, "POST");
		});
		$("#btnUpdate").click(function(e) {
			handleCallAPI(e, "PUT");
		});
	</script>
</body>
</html>