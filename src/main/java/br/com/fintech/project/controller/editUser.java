package br.com.fintech.project.controller;

import br.com.fintech.project.dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editarUsuario")
public class EditUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        // mudar a func (fiz no not)
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            int cdUsuario = Integer.parseInt(request.getParameter("cd_usuario"));

            if ("update".equals(action)) {
                String nome = request.getParameter("nom_usuario");
                String senha = request.getParameter("senha");

                // mudar a func (fiz no not)
                usuarioDAO.atualizar(cdUsuario, nome, senha);

            } else if ("delete".equals(action)) {
                // mudar a func (fiz no not)
                usuarioDAO.excluir(cdUsuario);
                HttpSession session = request.getSession();
                session.invalidate(); // logout automático após exclusão
            }

            response.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}