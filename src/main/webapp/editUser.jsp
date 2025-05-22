<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <link rel="stylesheet" href="./resource/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp"%>

<!-- CONTEÚDO PRINCIPAL -->
<main class="d-flex flex-column align-items-center justify-content-center p-5 m-5 border border-secondary rounded-4">
    <h2>Editar Usuario</h2>

    <!-- conteudo principal -->
    <div class="mb-5">
        <h3 class="mt-5">Oque deseja fazer hoje ?</h3>
        
        <!-- mudar email -->
        <div class="d-flex justify-content-center gap-3 p-3">
            <p>Mudar email ?</p>
            <input type="text" placeholder="Novo email">
            <button type="button" class="btn btn-primary">Mudar</button>
        </div>
        
        <!-- mudar senha -->
        <div class="d-flex justify-content-cente gap-3 p-3">
            <p>Trocar senha ?</p>
            <input type="text" placeholder="Nova senha">
            <button type="button" class="btn btn-primary">Trocar</button>
        </div>

        <!-- excluir usuario -->
        <div class="d-flex justify-content-cente gap-3 p-3">
            <p>Excluir usuario ?</p>
            <button type="button" class="btn btn-danger">Excluir</button>
        </div>
    </div>

    <!-- voltar ao menu -->
    <a href="#" class="btn btn-success">Voltar para menu principal</a>
</main>

<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>