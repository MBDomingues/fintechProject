<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <link rel="stylesheet" href="./resource/css/bootstrap.css">
</head>
<body>

<c:if test="${not empty erroLogin}">
    <div class="alert alert-danger">
            ${erroLogin}
    </div>
</c:if>

<div class="d-flex justify-content-center align-items-center position-absolute top-50 start-50 translate-middle">
    <div class="card">
        <div class="card-body">
            <form action="login" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" name="login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="senha" class="form-control" id="exampleInputPassword1">
                </div>
                <input type="submit" value="Entrar" class="btn btn-primary">
                <a href="register.jsp" class="btn btn-primary">Cadastrar</a>
            </form>
        </div>
    </div>
</div>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>