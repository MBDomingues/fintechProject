package br.com.fintech.project.controller;

import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Gastos;
import br.com.fintech.project.model.Metas;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/metas")
public class MetasServlet extends HttpServlet {
    private MetasDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getMetasDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioId") != null) {
            int usuarioId = (int) session.getAttribute("usuarioId");

            String acao = req.getParameter("acao");

            switch (acao) {
                case "cadastrar":
                    cadastrar(req, resp, usuarioId);
                    break;
                case "editar":
                    editar(req, resp, usuarioId);
            }

        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        String desc = req.getParameter("desc");
        double valor = Double.parseDouble(req.getParameter("valor"));
        double valor_atual = Double.parseDouble(req.getParameter("valor_atual"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        int codigo = Integer.valueOf(req.getParameter("codigo"));

        Metas m = new Metas(codigo, valor, data, desc,valor_atual, usuarioId);

        try {
            dao.alterarMeta(m);
            req.setAttribute("msg", "meta editado com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao editar Meta!");
        }
        // Redireciona (novo request)
        req.getRequestDispatcher("editarMetas.jsp").forward(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws IOException, ServletException {
        String desc = req.getParameter("desc");
        double valor = Double.parseDouble(req.getParameter("valor"));
        double valor_atual = Double.parseDouble(req.getParameter("valor_atual"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));

        Metas m = new Metas(0, valor, data, desc,valor_atual, usuarioId);

        try {
            dao.cadastrarMeta(m);
            req.setAttribute("inserido", "Meta inserida com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroMetas", "Erro ao inserir Meta!");
        }

        // Redireciona (novo request)
        req.getRequestDispatcher("cadastrarMetas.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioId") != null) {
            int usuarioId = (int) session.getAttribute("usuarioId");

            String acao = req.getParameter("acao");

            switch (acao) {
                case "listar":
                    listar(req, resp, usuarioId);
                    break;
                case "abrir-form-edicao":
                    abrirForm(req, resp);
            }





        }else {
            resp.sendRedirect("login.jsp");
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            Metas meta = dao.buscarMetasPorCodigo(codigo);
            req.setAttribute("meta", meta);
            req.getRequestDispatcher("editarMetas.jsp").forward(req, resp);
        } catch (DBExeption e) {
            e.printStackTrace();
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        try {
            List<Metas> listaMetas = dao.listarMetas(usuarioId);
            req.setAttribute("metas", listaMetas);
            req.getRequestDispatcher("metas.jsp").forward(req, resp);

        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroMeta", "Erro ao listar metas.");
            req.getRequestDispatcher("metas.jsp").forward(req, resp);
        }
    }
}
