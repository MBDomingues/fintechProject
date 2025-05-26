package br.com.fintech.project.teste;

import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Metas;

import java.time.LocalDate;

public class MetasDaoTeste {
    public static void main(String[] args) {
        MetasDao dao = DaoFactory.getMetasDao();

        LocalDate data = LocalDate.of(2026, 2, 12);
        try {
            Metas meta = new Metas(
                    0,
                    15200,
                    data,
                    "celular",
                    100,
                    19);

            dao.cadastrarMeta(meta);
            System.out.println("Meta cadastrada com sucesso");
        }catch (DBExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
