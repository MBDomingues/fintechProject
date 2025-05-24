package br.com.fintech.project.factory;

import br.com.fintech.project.dao.GastosDao;
import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.dao.UsuarioDao;
import br.com.fintech.project.dao.impl.OracleMetasDao;
import br.com.fintech.project.dao.impl.OracleUsuarioDao;
import br.com.fintech.project.dao.impl.OraclegastosDao;
import br.com.fintech.project.model.Metas;

public class DaoFactory {

    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();
    }

    public static MetasDao getMetasDao() {
        return new OracleMetasDao();
    }

    public static GastosDao getGastosDao() {
        return new OraclegastosDao();
    }
}
