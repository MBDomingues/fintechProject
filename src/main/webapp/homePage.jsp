<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <link rel="stylesheet" href="./resource/css/bootstrap.css">
    <link rel="stylesheet" href="./resource/css/homePgae.css">
</head>
<body>
<%@include file="header.jsp"%>

<!-- Conteúdo principal -->
<div class="d-flex justify-content-center align-items-center flex-column p-5 w-100">
    <h1>Olá!</h1>
    <p>Bem vindo a sua central financeira.</p>
</div>

<div class="container bg-white p-4 rounded-4 shadow-lg mt-5">
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <!-- Gastos -->
        <div class="col">
            <div class="card mb-3 shadow-sm h-100">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Gastos</h5>
                    <p class="text-muted">Visualize e cadastre todos os seus gastos mensais.</p>
                    <a href="gastos?acao=listar" class="btn btn-outline-primary w-100">Meus Gastos</a>
                </div>
            </div>
        </div>

        <!-- Renda -->
        <div class="col">
            <div class="card mb-3 shadow-sm h-100">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Renda</h5>
                    <p class="text-muted">Controle suas fontes de renda de forma prática.</p>
                    <a href="rendas?acao=listar" class="btn btn-outline-success w-100">Minhas Rendas</a>
                </div>
            </div>
        </div>

        <!-- Metas -->
        <div class="col">
            <div class="card shadow-sm h-100">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Metas</h5>
                    <p class="text-muted">Defina e acompanhe suas metas financeiras.</p>
                    <a href="metas?acao=listar" class="btn btn-outline-warning w-100">Minhas Metas</a>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>