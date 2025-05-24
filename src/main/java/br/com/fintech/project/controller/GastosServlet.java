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

@WebServlet("/inserirGasto")
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
            System.out.println(session.getAttribute("usuarioId"));
            try {
                List<Gastos> listaGastos = dao.listarGastos(usuarioId);
                req.setAttribute("gastos", listaGastos);
                System.out.println("Quantidade de gastos recuperados: " + listaGastos.size());
                req.getRequestDispatcher("gastos.jsp").forward(req, resp);

            } catch (DBExeption e) {
                e.printStackTrace();
                req.setAttribute("erroGasto", "Erro ao listar gastos.");
                req.getRequestDispatcher("gastos.jsp").forward(req, resp);
            }


        }else {
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("usuarioId") != null) {
            int usuarioId = (int) session.getAttribute("usuarioId");
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
            resp.sendRedirect("gastos.jsp");

        } else {
            resp.sendRedirect("gastos.jsp");
        }
    }


}
