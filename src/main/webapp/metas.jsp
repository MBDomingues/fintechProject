<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
        <h5 class="card-title text-center">Lista de Metas</h5>

        <table class="table table-bordered table-striped">
            <thead class="table-light">
            <tr>
                <th>Valor alvo</th>
                <th>Valor atual</th>
                <th>Descritivo</th>
                <th>Data para meta</th>
                <th>Editar</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${metas}" var="meta">
            <tr>
                <td>${meta.vl_alvo}</td>
                <td>${meta.vl_atual}</td>
                <td>${meta.descricao}</td>
                <td>
                    <fmt:parseDate
                            value="${meta.dt_alvo}"
                            pattern="yyyy-MM-dd"
                            var="dataMetaFMT"/>
                    <fmt:formatDate
                            value="${dataMetaFMT}"
                            pattern="dd/MM/yyyy"/>
                </td>
                <td class="text-center">
                    <c:url value="metas" var="link">
                        <c:param name="acao" value="abrir-form-edicao"/>
                        <c:param name="codigo" value="${meta.cd_meta}"/>
                    </c:url>
                    <a href="${link}" class="btn btn-primary">Editar</a>
                </td>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="./cadastrarMetas.jsp" class="btn btn-outline-primary mb-2 w-100">Nova Meta</a>
</div>
<%@include file="footer.jsp"%>
<script src="resource/js/bootstrap.bundle.js"></script>
</body>
</html>
