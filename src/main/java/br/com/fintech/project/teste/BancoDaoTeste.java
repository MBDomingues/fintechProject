package br.com.fintech.project.teste;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Banco;

import java.util.List;

public class BancoDaoTeste {
    public static void main(String[] args) {
        BancoDao dao = DaoFactory.getBancoDao();

//        CADASTRAR NOVO BANCO
//        Banco banco = new Banco(
//                0,
//                "XP"
//        );
//        try {
//            dao.cadastrarBanco(banco);
//            System.out.println("Banco cadastrado com sucesso");
//        } catch (DBExeption e)  {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.excluirBanco("Banco do brasil");
//            System.out.println("Banco removido com sucesso");
//        } catch (DBExeption e)  {
//            System.out.println(e.getMessage());
//        }
        try {
            List<Banco> bancos = dao.listarBancos();
            for (Banco banco : bancos) {
                System.out.println(banco.getNm_banco() + " " + banco.getCd_banco());
                System.out.println("___________");
            }
        }catch (DBExeption e){
            e.printStackTrace();
        }

    }
}
