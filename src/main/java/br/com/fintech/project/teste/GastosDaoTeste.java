package br.com.fintech.project.teste;

import br.com.fintech.project.dao.GastosDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Gastos;

import java.util.List;

public class GastosDaoTeste {
    public static void main(String[] args) {
        GastosDao dao = DaoFactory.getGastosDao();


        // Código do usuário para testar
        int codigo = 18;

        try {
            List<Gastos> listaGastos = dao.listarGastos(codigo);

            // Verificando se a lista está vazia
            if (listaGastos.isEmpty()) {
                System.out.println("Nenhum gasto encontrado para o usuário com código: " + codigo);
            } else {
                System.out.println("Lista de gastos do usuário " + codigo + ":");
                for (Gastos gasto : listaGastos) {
                    System.out.println("ID: " + gasto.getCd_gastos());
                    System.out.println("Valor: R$" + gasto.getVl_gastos());
                    System.out.println("Categoria: " + gasto.getCategoria());
                    System.out.println("Data: " + gasto.getDt_gasto());
                    System.out.println("Descrição: " + gasto.getDescricao());
                    System.out.println("---------------------------------");
                }
            }
        } catch (DBExeption e) {
            System.out.println("Erro ao listar gastos: " + e.getMessage());
            e.printStackTrace(); // Imprime o erro detalhado no console
        }
    }
    }
