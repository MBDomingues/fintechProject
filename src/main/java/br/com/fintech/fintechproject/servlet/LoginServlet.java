package br.com.fintech.fintechproject.servlet;

import br.com.fintech.fintechproject.dao.impl.UsuarioDaoImpl;
import br.com.fintech.fintechproject.model.Usuario;
import br.com.fintech.fintechproject.exeption.DBExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDaoImpl usuarioDao;

    @Override
    public void init() {
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            Usuario usuario = usuarioDao.validarLogin(nome, senha);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
                response.sendRedirect("homePage.jsp");
            } else {
                request.setAttribute("erroLogin", "Usuário ou senha inválidos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (DBExeption e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao tentar realizar o login.");
        }
    }
}
