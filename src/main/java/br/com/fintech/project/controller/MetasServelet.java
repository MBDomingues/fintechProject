package br.com.fintech.project.controller;

import br.com.fintech.project.dao.MetasDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import br.com.fintech.project.model.Metas;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/metas")
public class MetasServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        // mudar a func (fiz no not)
        MetasDAO metasDAO = new MetasDAO();

        try {
            if ("create".equals(action)) {
                double vlAlvo = Double.parseDouble(request.getParameter("vl_alvo"));
                Date dtAlvo = Date.valueOf(request.getParameter("dt_alvo"));
                String descricao = request.getParameter("descricao");
                double vlAtual = Double.parseDouble(request.getParameter("vl_atual"));
                int cdUsuario = Integer.parseInt(request.getParameter("cd_usuario"));

                // mudar a func (fiz no not)
                Meta meta = new Meta(0, vlAlvo, dtAlvo, descricao, vlAtual, cdUsuario);
                metasDAO.inserir(meta);

            } else if ("update".equals(action)) {
                int cdMeta = Integer.parseInt(request.getParameter("cd_meta"));
                double vlAlvo = Double.parseDouble(request.getParameter("vl_alvo"));
                Date dtAlvo = Date.valueOf(request.getParameter("dt_alvo"));
                String descricao = request.getParameter("descricao");
                double vlAtual = Double.parseDouble(request.getParameter("vl_atual"));
                int cdUsuario = Integer.parseInt(request.getParameter("cd_usuario"));

                // mudar a func (fiz no not)
                Meta meta = new Meta(cdMeta, vlAlvo, dtAlvo, descricao, vlAtual, cdUsuario);
                metasDAO.atualizar(meta);

            } else if ("delete".equals(action)) {
                int cdMeta = Integer.parseInt(request.getParameter("cd_meta"));

                // mudar a func (fiz no not)
                metasDAO.excluir(cdMeta);
            }

            response.sendRedirect("metas.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}