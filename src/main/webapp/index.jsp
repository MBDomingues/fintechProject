<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <link rel="stylesheet" href="./resource/css/bootstrap.css">
</head>
<body>
<div class="d-flex justify-content-center align-items-center position-absolute top-50 start-50 translate-middle">
    <div class="card">
        <div class="card-body">
            <form action="usuario" method="post" >
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <a href="homePage.jsp" class="btn btn-primary">Entrar</a>
                <a href="register.jsp" class="btn btn-primary">Cadastrar</a>

            </form>
        </div>
    </div>
</div>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>