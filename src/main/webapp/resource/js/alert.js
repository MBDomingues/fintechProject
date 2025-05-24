// Espera o carregamento completo da página
window.addEventListener('DOMContentLoaded', () => {
    // Seleciona todos os alertas visíveis
    const alertas = document.querySelectorAll('.alert');

    alertas.forEach(alerta => {
        // Aguarda 3 segundos, depois começa a ocultar o alerta
        setTimeout(() => {
            alerta.classList.remove('show'); // some com efeito do Bootstrap
            alerta.classList.add('fade');    // garante a transição suave

            // Opcional: remove do DOM após o fade-out
            setTimeout(() => {
                alerta.remove();
            }, 500); // tempo para o fade terminar
        }, 3000);
    });
});





