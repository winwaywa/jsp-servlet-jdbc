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
<title>Login</title>
</head>
<body>
	<section style="background-color: #9A616D; height: 100vh">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">

				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
									alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-4 p-lg-5 text-black">
									<c:if test="${not empty message}">
										<div class="alert alert-${alert}" role="alert">${message}</div>
									</c:if>
									<form method="POST"
										action="<c:url value='/login?action=login'/>">
										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
											<span class="h1 fw-bold mb-0">Login</span>
										</div>


										<div class="form-outline mb-4">
											<input name="userName" type="username" id="inputUsername"
												class="form-control form-control-lg" /> <label
												class="form-label" for="inputUsername">Username</label>
										</div>

										<div class="form-outline mb-4">
											<input name="passWord" type="password" id="inputPassword"
												class="form-control form-control-lg" /> <label
												class="form-label" for="inputPassword">Password</label>
										</div>

										<div class="pt-1 mb-4">
											<button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
										</div>

										<a class="small text-muted" href="#!">Forgot password?</a>
										<p class="mb-5 pb-lg-2" style="color: #393f81;">
											Don't have an account? <a href="#!" style="color: #393f81;">Register
												here</a>
										</p>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>