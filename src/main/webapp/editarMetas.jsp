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
    <h2 class="text-center mb-4">Metas</h2>
    <!-- Formulário de cadastro de gasto -->
    <div class="card shadow m-5">
        <div class="card-body">
            <h5 class="card-title">Editar Meta</h5>
            <c:if test="${not empty msg}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">
                        ${msg}
                </div>
            </c:if>

            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 m-auto mt-2">
                        ${erro}
                </div>
            </c:if>
            <form action="metas?acao=editar" method="post">

                <input type="hidden" value="${meta.cd_meta}" name="codigo">

                <div class="mb-3">
                    <label for="descricao" class="form-label">Descritivo</label>
                    <input type="text" name="desc" class="form-control" id="descricao" required value="${meta.descricao}"/>
                </div>

                <div class="mb-3">
                    <label for="valor" class="form-label">Valor alvo (R$)</label>
                    <input type="number" name="valor" class="form-control" id="valor" step="0.01" required value="${meta.vl_alvo}" />
                </div>

                <div class="mb-3">
                    <label for="data" class="form-label">Data para atingir</label>
                    <input type="date" name="data" class="form-control" id="data" required value="${meta.dt_alvo}" />
                </div>

                <div class="mb-3">
                    <label for="valor_atual" class="form-label">Valor Atual (R$)</label>
                    <input type="text" name="valor_atual" class="form-control" id="valor_atual" required value="${meta.vl_atual}" />
                </div>

                <input type="submit" value="salvar" class="btn btn-primary w-100">
            </form>
        </div>
    </div>
</div>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>

</html>
