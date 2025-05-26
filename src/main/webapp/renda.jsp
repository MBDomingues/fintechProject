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

<!-- Tabela de gastos -->
<div class="card shadow mt-4">
  <div class="card-body">
    <h5 class="card-title text-center">Lista de Rendas</h5>

    <table class="table table-bordered table-striped">
      <thead class="table-light">
      <tr>
        <th>Valor Renda</th>
        <th>ococrrencia</th>
        <th>Tipo de Renda</th>
        <th>Editar</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${rendas}" var="renda">
      <tr>
        <td>${renda.vl_renda}</td>
        <td>${renda.frequencia}</td>
        <td>${renda.tp_renda}</td>
        <td class="text-center">
          <c:url value="rendas" var="link">
            <c:param name="acao" value="abrir-form-edicao"/>
            <c:param name="codigo" value="${renda.cd_renda}"/>
          </c:url>
          <a href="${link}" class="btn btn-primary">Editar</a>
        </td>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <a href="./cadastrarRenda.jsp" class="btn btn-outline-primary mb-2 w-100">Nova Renda</a>
</div>
<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>
