package br.com.fintech.project.controller;

import br.com.fintech.project.dao.RendaDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Gastos;
import br.com.fintech.project.model.Metas;
import br.com.fintech.project.model.Renda;
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

@WebServlet("/rendas")
public class RendasServlet extends HttpServlet {
    private RendaDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getRendaDao();
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
            Renda renda = dao.buscarRendaPorId(codigo);
            req.setAttribute("renda", renda);
            req.getRequestDispatcher("editarRenda.jsp").forward(req, resp);
        } catch (DBExeption e) {
            e.printStackTrace();
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        try {
            List<Renda> rendas = dao.listarRendas(usuarioId);
            req.setAttribute("rendas", rendas);
            req.getRequestDispatcher("renda.jsp").forward(req, resp);

        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroRenda", "Erro ao listar rendas.");
            req.getRequestDispatcher("renda.jsp").forward(req, resp);
        }
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
                    break;
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        int valor = Integer.parseInt(req.getParameter("valor"));
        String frequencia = req.getParameter("frequencia");
        String tipo = req.getParameter("tipo");

        Renda renda = new Renda(codigo, valor, frequencia, tipo, usuarioId);
        try {
            dao.alterarRenda(renda);
            req.setAttribute("msg", "Renda editada com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao editar Renda!");
        }
        // Redireciona (novo request)
        req.getRequestDispatcher("editarRenda.jsp").forward(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        int valor = Integer.parseInt(req.getParameter("valor"));
        String frequencia = req.getParameter("frequencia");
        String tipo = req.getParameter("tipo");

        Renda renda = new Renda(0, valor, frequencia, tipo, usuarioId);
        try {
            dao.inserirRenda(renda);
            req.setAttribute("inserido", "Renda inserida com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroRenda", "Erro ao inserir Gastos!");
        }

        // Redireciona (novo request)
        req.getRequestDispatcher("cadastrarRenda.jsp").forward(req, resp);
    }
}
