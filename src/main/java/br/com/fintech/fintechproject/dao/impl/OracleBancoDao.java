package br.com.fintech.fintechproject.dao.impl;

//IMPORTS

import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE BANCODAO DA TEBELA DAO
public class OracleBancoDao {

    private Banco banco;

    //CONSTRUTOR
    public OracleBancoDao(Banco banco) {
        this.banco = banco;
    }

    //CONSTRUTOR PADRÃO
    public OracleBancoDao(){}

    //GETTERS AND SETTERS

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    //METODO PARA CADASTRAR DADOS NA TABELA BANCO
    public void registrarBanco () throws SQLException{

        Connection connection = ConnectionFactory.getConnection();

        String sql = "insert into t_banco (cd_banco, nm_banco) values(?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, banco.getCd_banco());
        ps.setString(2, banco.getNm_banco());

        ps.executeUpdate();
    }

    //METODO PARA LISTAR TODOS OS EMAILS

    public List<Banco> listarBancos() throws SQLException{

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_banco order by cd_banco";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Banco> listarBancos = new ArrayList<>();

        while(rs.next()){
            Banco bancos = new Banco();
            bancos.setCd_banco(rs.getInt("cd_banco"));
            bancos.setNm_banco(rs.getString("nm_banco"));
            listarBancos.add(bancos);
        }
        return listarBancos;
    }
}
