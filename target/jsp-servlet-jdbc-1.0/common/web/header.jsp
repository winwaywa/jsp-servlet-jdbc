<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="#!">AWS Learning</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul
				class="navbar-nav ms-auto mb-2 mb-lg-0 mr-auto">
				<li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#">Blog</a></li>
			</ul>
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item"><a class="nav-link" href="#">Welcome,
							${USERMODEL.fullName}</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='logout?action=logout'/>">logout</a></li>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='login?action=login'/>">login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>