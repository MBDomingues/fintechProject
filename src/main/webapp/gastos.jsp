<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h5 class="card-title text-center">Lista de Gastos</h5>

        <table class="table table-striped table-bordered">
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
              <td>${gasto.vl_gastos}</td>
              <td>${gasto.categoria}</td>
              <td>
                <fmt:parseDate
                        value="${gasto.dt_gasto}"
                        pattern="yyyy-MM-dd"
                        var="dataFMT"/>
                <fmt:formatDate
                        value="${dataFMT}"
                        pattern="dd/MM/yyyy"/>
              </td>
              <td class="text-center">
                <c:url value="gastos" var="link">
                  <c:param name="acao" value="abrir-form-edicao"/>
                  <c:param name="codigo" value="${gasto.cd_gastos}"/>
                </c:url>
                <a href="${link}" class="btn btn-primary">Editar</a>

              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <a href="cadastrarGastos.jsp" class="btn btn-outline-primary mb-2 w-100">Novo Gasto</a>
    </div>
  <%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>
