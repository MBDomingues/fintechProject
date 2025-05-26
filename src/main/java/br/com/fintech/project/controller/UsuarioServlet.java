package br.com.fintech.project.controller;

import br.com.fintech.project.dao.UsuarioDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        switch (acao) {
            case "logar":
                logar(req, resp);
                break;
            case "cadastrar":
                Cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;

        }


    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioId") != null) {
            int usuarioId = (int) session.getAttribute("usuarioId");
            String senha = req.getParameter("senha");
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String tipo = req.getParameter("tipo");


            Usuario usuario = new Usuario(
                    usuarioId,
                    nome,
                    senha,
                    0,
                    email,
                    tipo
            );
            try {
                dao.alterarUsuario(usuario);
                req.setAttribute("msg", "usuario alterado com sucesso!");
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
            } catch (DBExeption e) {
                e.printStackTrace();
                req.setAttribute("erro", "Erro ao editar usuario!");
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
            }

        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    private void logar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String emailWeb = req.getParameter("login");
        String senhaWeb = req.getParameter("senha");

        try {
            Usuario usuario = dao.buscarUsuarioPoremail(emailWeb); // Corrigido para capturar o retorno
            if (usuario != null) {
                String email = usuario.getNom_email();
                String senha = usuario.getPassword();

                if (senhaWeb.equals(senha)) {

                    HttpSession session = req.getSession();
                    session.setAttribute("usuarioId", usuario.getCd_user());

                    // Login bem-sucedido
                    resp.sendRedirect("homePage.jsp");
                } else {
                    req.setAttribute("erroLogin", "Usuário ou senha incorretos");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("erroLogin", "Usuário não encontrado");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroLogin", e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, resp); // Volta para login com erro técnico
        }
    }

    private void Cadastrar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String senha = req.getParameter("senha");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String tipo = req.getParameter("tipo");

        Usuario usuario = new Usuario(
                0,
                nome,
                senha,
                0,
                email,
                tipo
        );
        try {
            dao.cadastrarUsuario(usuario);
            resp.sendRedirect("index.jsp");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroCadastro", "Erro ao inserir usuario!");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        switch (acao) {
            case "editar":
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                break;
        }
    }
}
