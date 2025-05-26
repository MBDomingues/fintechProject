<link rel="stylesheet" href="./resource/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.11.3/font/bootstrap-icons.min.css">

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">RENDE +</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="./homePage.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="gastos?acao=listar">Gastos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="metas?acao=listar">Metas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="rendas?acao=listar">Renda</a>
                </li>
            <!-- Botão de usuário à direita -->
            <a href="./editUser.jsp" class="btn btn-outline-secondary position-absolute end-0 me-3">
                <i class="bi bi-person-circle"></i> <!-- Ícone Bootstrap -->
            </a>
        </div>
    </div>
</nav>

<script src="resource/js/bootstrap.bundle.js"></script>