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
  <h2 class="text-center mb-4">GASTOS</h2>
  <!-- Formulário de cadastro de gasto -->
  <div class="card shadow m-5">
    <div class="card-body">
      <h5 class="card-title">Editar Gasto</h5>
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
      <form action="gastos?acao=editar" method="post">

        <input type="hidden" value="${gasto.cd_gastos}" name="codigo">

        <div class="mb-3">
          <label for="descricao" class="form-label">Descritivo</label>
          <input type="text" name="desc" class="form-control" id="descricao" required value="${gasto.descricao}" />
        </div>

        <div class="mb-3">
          <label for="valor" class="form-label">Valor (R$)</label>
          <input type="number" name="valor" class="form-control" id="valor" step="0.01" required value="${gasto.vl_gastos}" />
        </div>

        <div class="mb-3">
          <label for="data" class="form-label">Data do Gasto</label>
          <input type="date" name="data" class="form-control" id="data" required value="${gasto.dt_gasto}" />
        </div>

        <div class="mb-3">
          <label for="categoria" class="form-label">Categoria</label>
          <input type="text" name="categoria" class="form-control" id="categoria" required value="${gasto.categoria}" />
        </div>
        <input type="submit" value="Salvar" class="btn btn-primary w-100">
      </form>
    </div>
  </div>
</div>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>

</html>
