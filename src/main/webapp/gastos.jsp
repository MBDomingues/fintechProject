<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
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
              <button
                      type="button"
                      class="btn btn-danger"
                      data-bs-toggle="modal"
                      data-bs-target="#excluirModal"
                      onclick="codigoExcluir.value = ${gasto.cd_gastos}">
                Excluir
              </button>

            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <a href="cadastrarGastos.jsp" class="btn btn-outline-primary mb-2 w-100">Novo Gasto</a>
  </div>
<!-- Modal -->
<div
        class="modal fade"
        id="excluirModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1
                class="modal-title fs-5"
                id="exampleModalLabel">
          Confirmar Exclusão
        </h1>
        <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
        <h4>Você confirma a exclusão deste produto?</h4>
        <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
      </div>
      <div class="modal-footer">

        <form action="gastos" method="post">
          <input
                  type="hidden"
                  name="acao"
                  value="excluir">
          <input
                  type="hidden"
                  name="codigoExcluir"
                  id="codigoExcluir">
          <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal">
            Não
          </button>
          <button
                  type="submit"
                  class="btn btn-danger">
            Sim
          </button>
        </form>

      </div>
    </div>
  </div>
</div>
<%--    fim modal--%>

<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>
