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
<div class="container mt-5">
    <h2 class="text-center mb-4">Bem-vindo à sua central financeira</h2>

    <div class="row g-4">

        <!-- GASTOS -->
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title">Gastos</h5>
                    <p class="card-text">Visualize e cadastre todos os seus gastos mensais.</p>
                    <a href="listar-gastos.jsp" class="btn btn-outline-primary mb-2 w-100">Visualizar Gastos</a>
                    <a href="cadastrar-gasto.jsp" class="btn btn-primary w-100">Cadastrar Gasto</a>
                </div>
            </div>
        </div>

        <!-- RENDA -->
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title">Renda</h5>
                    <p class="card-text">Controle suas fontes de renda de forma prática.</p>
                    <a href="listar-renda.jsp" class="btn btn-outline-success mb-2 w-100">Visualizar Renda</a>
                    <a href="cadastrar-renda.jsp" class="btn btn-success w-100">Cadastrar Renda</a>
                </div>
            </div>
        </div>

        <!-- METAS -->
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title">Metas</h5>
                    <p class="card-text">Defina e acompanhe suas metas financeiras.</p>
                    <a href="listar-metas.jsp" class="btn btn-outline-warning mb-2 w-100">Visualizar Metas</a>
                    <a href="cadastrar-meta.jsp" class="btn btn-warning text-white w-100">Cadastrar Meta</a>
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>