<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title><decorator:title default="Home" /></title>

<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/styles.css'/>"
	rel="stylesheet" type="text/css" media="all" />

</head>
<body>

	<!-- header  -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header  -->

	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-8">
				<!-- prefix="decorator" in taglib.jsp %>-->
				<decorator:body />
			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<%@ include file="/common/web/sidebar.jsp"%>
			</div>
		</div>
	</div>

	<!-- footer  -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer  -->


	<script
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/web/jquery/jquery-3.7.1.min.js'/>"></script>
</body>
</html>