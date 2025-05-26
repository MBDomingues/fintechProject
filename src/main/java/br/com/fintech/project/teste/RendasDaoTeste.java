package br.com.fintech.project.teste;

import br.com.fintech.project.dao.RendaDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Renda;

import java.sql.SQLException;
import java.util.List;

public class RendasDaoTeste {
    public static void main(String[] args) {

        // Criando instância do DAO
        RendaDao dao = DaoFactory.getRendaDao();

        // Código do usuário para teste
        int codigoUsuario = 19;
        Renda novaRenda = new Renda(0, 3500.00, "Mensal", "Salário", 19);

        try {
            // Inserindo a renda
            dao.inserirRenda(novaRenda);
            System.out.println("Renda inserida com sucesso!");

        } catch (DBExeption e) {
            System.out.println("Erro ao inserir renda: " + e.getMessage());
            e.printStackTrace(); // Exibe detalhes do erro
        }
    }

//        try {
//            List<Renda> listaRendas = dao.listarRendas(codigoUsuario);
//
//            // Teste se há rendas
//            if (listaRendas.isEmpty()) {
//                System.out.println("Nenhuma renda encontrada para o usuário com código: " + codigoUsuario);
//            } else {
//                System.out.println("Lista de rendas do usuário " + codigoUsuario + ":");
//                for (Renda renda : listaRendas) {
//                    System.out.println("ID: " + renda.getCd_renda());
//                    System.out.println("Valor: R$ " + renda.getVl_renda());
//                    System.out.println("Frequência: " + renda.getFrequencia());
//                    System.out.println("Tipo: " + renda.getTp_renda());
//                    System.out.println("---------------------------------");
//                }
//            }
//        } catch (DBExeption e) {
//            System.out.println("Erro ao listar rendas: " + e.getMessage());
//            e.printStackTrace(); // Imprime detalhes do erro
//        }
    }



