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
            Usuario usuario = dao.buscarUsuarioPoremail(emailWeb); // Corrigido para capturar o retorno
            if (usuario != null) {
                String email = usuario.getNom_email();
                String senha = usuario.getPassword();

                if (senhaWeb.equals(senha)) {
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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
