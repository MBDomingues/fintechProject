<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Renda - Fintech</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
  />
</head>
<body class="bg-light">

  <!-- Cabeçalho -->
  <%@include file="header.jsp"%>

  <div class="container pb-5">
    <h2 class="text-center mb-4">RENDA</h2>

    <!-- Formulário de cadastro de renda -->
    <div class="card shadow mb-4">
      <div class="card-body">
        <h5 class="card-title">Cadastrar Renda</h5>
        <form id="form-renda">
          <div class="mb-3">
            <label for="descricao" class="form-label">Descrição</label>
            <input type="text" class="form-control" id="descricao" required />
          </div>
          <div class="mb-3">
            <label for="valor" class="form-label">Valor (R$)</label>
            <input type="number" class="form-control" id="valor" step="0.01" required />
          </div>
          <button type="submit" value="Registrar" class="btn btn-success w-100"></button>
        </form>
      </div>
    </div>

    <!-- Tabela de rendas -->
    <div class="card shadow">
      <div class="card-body">
        <h5 class="card-title">Lista de Rendas</h5>
        <table class="table table-bordered">
          <thead class="table-light">
            <tr>
              <th>Descrição</th>
              <th>Valor (R$)</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody id="lista-rendas">
            <!-- Linhas adicionadas dinamicamente -->
          </tbody>
        </table>
      </div>
    </div>
  </div>

  <script>
    let rendas = [];
    let editandoIndex = null;

    const form = document.getElementById("form-renda");
    const listaRendas = document.getElementById("lista-rendas");

    form.addEventListener("submit", (e) => {
      e.preventDefault();
      const descricao = document.getElementById("descricao").value.trim();
      const valor = parseFloat(document.getElementById("valor").value);

      if (!descricao || isNaN(valor)) return;

      if (editandoIndex !== null) {
        rendas[editandoIndex] = { descricao, valor };
        editandoIndex = null;
      } else {
        rendas.push({ descricao, valor });
      }

      form.reset();
      renderizarLista();
    });

    function renderizarLista() {
      listaRendas.innerHTML = "";
      rendas.forEach((item, index) => {
        const valorFormatado = item.valor.toLocaleString("pt-BR", {
          style: "currency",
          currency: "BRL",
        });

        const row = `
          <tr>
            <td>${item.descricao}</td>
            <td>${valorFormatado}</td>
            <td>
              <button class='btn btn-sm btn-outline-warning me-2' onclick='editar(${index})'>Editar</button>
              <button class='btn btn-sm btn-outline-danger' onclick='excluir(${index})'>Excluir</button>
            </td>
          </tr>
        `;
        listaRendas.insertAdjacentHTML("beforeend", row);
      });
    }

    function editar(index) {
      const renda = rendas[index];
      document.getElementById("descricao").value = renda.descricao;
      document.getElementById("valor").value = renda.valor;
      editandoIndex = index;
    }

    function excluir(index) {
      rendas.splice(index, 1);
      renderizarLista();
    }
  </script>

</body>
</html>
