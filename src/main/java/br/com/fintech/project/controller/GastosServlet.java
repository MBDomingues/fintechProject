package br.com.fintech.project.controller;

import br.com.fintech.project.dao.GastosDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Gastos;
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

@WebServlet("/gastos")
public class GastosServlet extends HttpServlet {

    private GastosDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getGastosDao();
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
                    break;
            }
        }else {
            resp.sendRedirect("login.jsp");
        }

    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            Gastos gasto = dao.buscarGastoPorId(codigo);
            req.setAttribute("gasto", gasto);
            req.getRequestDispatcher("editarGastos.jsp").forward(req, resp);
        } catch (DBExeption e) {
            e.printStackTrace();
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws ServletException, IOException {
        try {
            List<Gastos> listaGastos = dao.listarGastos(usuarioId);
            req.setAttribute("gastos", listaGastos);
            req.getRequestDispatcher("gastos.jsp").forward(req, resp);

        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroGasto", "Erro ao listar gastos.");
            req.getRequestDispatcher("gastos.jsp").forward(req, resp);
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
                case "excluir":
                    excluir(req, resp);
                    break;
            }


        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int codigo = Integer.parseInt(req.getParameter("codigoExcluir"));
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioId") != null) {
            int usuarioId = (int) session.getAttribute("usuarioId");

            try {
                dao.excluirGastos(codigo);
                req.setAttribute("msg", "Gasto removido!");
            } catch (DBExeption e) {
                e.printStackTrace();
                req.setAttribute("erro", "Erro ao remover gasto.");
            }
            listar(req, resp, usuarioId);

        } else {
            resp.sendRedirect("index.jsp");
        }
    }


    private void cadastrar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws IOException, ServletException {
        String desc = req.getParameter("desc");
        double valor = Double.parseDouble(req.getParameter("valor"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        String categoria = req.getParameter("categoria");

        Gastos g = new Gastos(0, valor, categoria, data, desc, usuarioId);

        try {
            dao.inserirGastos(g);
            req.setAttribute("inserido", "Gasto inserido com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erroGasto", "Erro ao inserir Gastos!");
        }

        // Redireciona (novo request)
        req.getRequestDispatcher("cadastrarGastos.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp, int usuarioId) throws IOException, ServletException {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        String desc = req.getParameter("desc");
        double valor = Double.parseDouble(req.getParameter("valor"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        String categoria = req.getParameter("categoria");

        Gastos g = new Gastos(codigo, valor, categoria, data, desc, usuarioId);

        try {
            dao.alterarGastos(g);
            req.setAttribute("msg", "Gasto atualizado com sucesso!");
        } catch (DBExeption e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar Gastos!");
        }
        // Redireciona (novo request)
        req.getRequestDispatcher("editarGastos.jsp").forward(req, resp);
    }

}



