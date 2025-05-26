<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gastos - Fintech</title>
    <link rel="stylesheet" href="./resource/css/bootstrap.css">
</head>
<body>
<!-- Cabeçalho -->
<%@include file="header.jsp"%>

<div class="container pb-5">
    <h2 class="text-center mb-4">Rendas</h2>
    <!-- Formulário de cadastro de gasto -->
    <div class="card shadow m-5">
        <div class="card-body">
            <h5 class="card-title">Cadastrar Renda</h5>
            <c:if test="${not empty inserido}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">
                        ${inserido}
                </div>
            </c:if>

            <c:if test="${not empty erroRenda}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">
                        ${erroGasto}
                </div>
            </c:if>
            <form action="rendas?acao=cadastrar" method="post">
                <div class="mb-3">
                    <label for="valor" class="form-label">Valor da renda (R$)</label>
                    <input type="number" name="valor" class="form-control" id="valor" step="0.01" required />
                </div>
                <div class="mb-3">
                    <label for="frequencia" class="form-label">Frequencia</label>
                    <input type="text" name="frequencia" class="form-control" id="frequencia" required />
                </div>
                <div class="mb-3">
                    <label for="tp_renda" class="form-label">Tipo da renda</label>
                    <input type="text" name="tipo" class="form-control" id="tp_renda" required />
                </div>
                <input type="submit" value="Cadastrar" class="btn btn-primary w-100">
            </form>
        </div>
    </div>
</div>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>

</html>
