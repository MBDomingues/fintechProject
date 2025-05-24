<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Gastos - Fintech</title>
  <link rel="stylesheet" href="./resource/css/bootstrap.css">
</head>
<body class="bg-light">

  <!-- Cabeçalho -->
  <%@include file="header.jsp"%>


  <div class="container pb-5">
    <h2 class="text-center mb-4">GASTOS</h2>

    <!-- Formulário de cadastro de gasto -->
    <div class="card shadow mb-4">
      <div class="card-body">
        <h5 class="card-title">Cadastrar Gasto</h5>
        <c:if test="${not empty inserido}">
          <div class="alert alert-success ms-2 me-2 m-auto mt-2">
              ${inserido}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar"></button>
          </div>
        </c:if>

        <c:if test="${not empty erroGasto}">
          <div class="alert alert-success ms-2 me-2 m-auto mt-2">
              ${erroGasto}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Fechar"></button>
          </div>
        </c:if>


        <form action="inserirGasto" method="post">
          <div class="mb-3">
            <label for="descricao" class="form-label">Descritivo</label>
            <input type="text" name="desc" class="form-control" id="descricao" required />
          </div>
          <div class="mb-3">
            <label for="valor" class="form-label">Valor (R$)</label>
            <input type="number" name="valor" class="form-control" id="valor" step="0.01" required />
          </div>
          <div class="mb-3">
            <label for="data" class="form-label">Data do Gasto</label>
            <input type="date" name="data" class="form-control" id="data" required />
          </div>
          <div class="mb-3">
            <label for="categoria" class="form-label">Categoria</label>
            <input type="text" name="categoria" class="form-control" id="categoria" required />
          </div>
          <input type="submit" value="Cadastrar" class="btn btn-primary w-100">
        </form>
      </div>
    </div>

    <!-- Tabela de gastos -->
    <div class="card shadow mt-4">
      <div class="card-body">
        <h5 class="card-title">Lista de Gastos</h5>

        <table class="table table-bordered">
          <thead class="table-light">
          <tr>
            <th>Descritivo</th>
            <th>Valor (R$)</th>
            <th>Categoria</th>
            <th>Data</th>
            <th>Editar</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${gastos}" var="gasto">
            <tr>
              <td>${gasto.descricao}</td>
              <td>${gasto.vl.gasto}</td>
              <td>${gasto.categoria}</td>
              <td>${gasto.dt_gasto}</td>
          </c:forEach>
          </tbody>
        </table>
        <!-- Caso não existam gastos -->
        <c:if test="${empty listaGastos}">
          <div class="alert alert-info text-center mt-3">
            Nenhum gasto cadastrado.
          </div>
        </c:if>
      </div>
    </div>

      <%
    Object usuarioId = session.getAttribute("usuarioId");
    if (usuarioId != null) {
%>
    <p>ID do usuário logado: <%= usuarioId %></p>
      <%
} else {
%>
    <p>Usuário não logado.</p>
      <%
    }
%>

<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>
