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
<main class="d-flex flex-column align-items-center justify-content-center p-5">
    <!-- titulo -->
    <h3>Suas metas</h3>

    <!-- coonteudo principal -->
    <div class="w-100 d-flex flex-column align-items-center">
        <!-- cabeçalho -->
        <div class="mt-4">
            <div class="d-flex  gap-4 p-3">
                <p><strong>Nome</strong></p>
                <p><strong>Valor alvo</strong></p>
                <p><strong>Valor atual</strong></p>
            </div>
        </div>

        <!-- meta de exemplo -->
        <div class="w-50 border rounded-4 m-1 d-flex flex-column align-items-center">
            <!-- infos da meta -->
            <div class="d-flex  gap-4 p-3">
                <p>NomeMeta 1</p>
                <p>Valor alvo 1</p>
                <p>Valor meta atual 1</p>
            </div>

            <!-- bottoens da meta -->
            <div class="d-flex gap-3 p-3">
                <button type="button" class="btn btn-primary">Mudar nome</button>
                <button type="button" class="btn btn-warning">Mudar valor alvo</button>
                <button type="button" class="btn btn-danger">Exlcuir meta</button>
            </div>
        </div>

        <!-- meta de exemplo -->
        <div class="w-50 border rounded-4 m-1 d-flex flex-column align-items-center">
            <!-- infos da meta -->
            <div class="d-flex  gap-4 p-3">
                <p>NomeMeta 2</p>
                <p>Valor alvo 2</p>
                <p>Valor meta atual 2</p>
            </div>

            <!-- bottoens da meta -->
            <div class="d-flex gap-3 p-3">
                <button type="button" class="btn btn-primary">Mudar nome</button>
                <button type="button" class="btn btn-warning">Mudar valor alvo</button>
                <button type="button" class="btn btn-danger">Exlcuir meta</button>
            </div>
        </div>
    </div>

    <!-- voltar ao menu -->
    <a href="#" class="btn btn-success mt-5">Voltar para menu principal</a>
</main>

<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>