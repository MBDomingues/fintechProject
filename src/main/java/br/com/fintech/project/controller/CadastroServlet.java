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

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    private UsuarioDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        super.doGet(req, resp);
    }
}
