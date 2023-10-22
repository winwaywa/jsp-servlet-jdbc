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
	<decorator:body />
	<script
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/web/jquery/jquery-3.7.1.min.js'/>"></script>
</body>
</html>