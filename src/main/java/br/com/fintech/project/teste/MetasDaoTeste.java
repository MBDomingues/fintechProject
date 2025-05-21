package br.com.fintech.project.teste;

import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Banco;
import br.com.fintech.project.model.Metas;

public class MetasDaoTeste {
    public static void main(String[] args) {
        MetasDao dao = DaoFactory.getMetasDao();


        try {
            Metas meta = new Metas(
                    0,
                    15200,
                    "12/12/12",
                    "carro",
                    100,
                    2);

            dao.cadastrarMeta(meta);
            System.out.println("Meta cadastrada com sucesso");
        }catch (DBExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
