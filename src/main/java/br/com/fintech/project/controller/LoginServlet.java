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

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailWeb = req.getParameter("login");
        String senhaWeb = req.getParameter("senha");

        try {
            // Pega o usuário correspondente ao e-mail fornecido
            Usuario usuario = dao.buscarUsuarioPoremail(emailWeb);

            // Verifica se o usuário existe e se a senha bate
            if (usuario == null || !usuario.getPassword().equals(senhaWeb)) {
                req.setAttribute("erroLogin", "Usuário ou senha incorretos");
            } else {
                resp.sendRedirect("homePage.jsp"); // Login bem-sucedido
            }

        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroLogin", e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, resp); // Volta para login com erro técnico
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
