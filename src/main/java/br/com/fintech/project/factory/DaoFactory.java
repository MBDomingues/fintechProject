package br.com.fintech.project.factory;

import br.com.fintech.project.dao.BancoDao;
import br.com.fintech.project.dao.UsuarioDao;
import br.com.fintech.project.dao.impl.OracleBancoDao;
import br.com.fintech.project.dao.impl.OracleUsuarioDao;

public class DaoFactory {

    public static BancoDao getBancoDao() {
        return new OracleBancoDao();
    }

    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();
    }
}
