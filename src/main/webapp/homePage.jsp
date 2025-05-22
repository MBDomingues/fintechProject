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
<div class="container bg-white p-4 rounded-4 shadow-lg mt-5">
    <div class="row g-4">
        <!-- Resumo Financeiro -->
        <div class="col-lg-7 col-md-12">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Resumo Financeiro</h5>
                </div>
                <div class="card-body">
                    <p><strong>Total de Rendas:</strong> <span class="text-success">R$ 5.000,00</span></p>
                    <p><strong>Total de Gastos:</strong> <span class="text-danger">R$ 2.300,00</span></p>
                    <p><strong>Metas Cadastradas:</strong> <span class="text-warning">3 metas</span></p>
                </div>
            </div>
        </div>

        <!-- Cards de ações -->
        <div class="col-lg-5 col-md-12">
            <!-- Gastos -->
            <div class="card mb-3 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Gastos</h5>
                    <p class="text-muted">Visualize e cadastre todos os seus gastos mensais.</p>
                    <a href="#" class="btn btn-outline-primary mb-2 w-100">Meus Gastos</a>
                </div>
            </div>

            <!-- Renda -->
            <div class="card mb-3 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Renda</h5>
                    <p class="text-muted">Controle suas fontes de renda de forma prática.</p>
                    <a href="." class="btn btn-outline-success mb-2 w-100">Minhas Rendas</a>
                </div>
            </div>

            <!-- Metas -->
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title fw-semibold">Metas</h5>
                    <p class="text-muted">Defina e acompanhe suas metas financeiras.</p>
                    <a href="metas.jsp" class="btn btn-outline-warning mb-2 w-100">Minhas Metas</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>