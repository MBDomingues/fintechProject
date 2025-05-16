package br.com.fintech.fintechproject.dao.impl;

//IMPORTS

import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE CONTADAO DA TABELA CONTA
public class OracleContaDao {

    private Conta conta;

    //CONSTRUTOR
    public OracleContaDao(Conta conta) {
        this.conta = conta;
    }

    //CONSTRUTOR PADRÃO
    public OracleContaDao() {}

    //GETTER AND SETTER
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    //METODO PARA CADASTRAR DADOS NA TABELA CONTA
    public void cadastrarConta () throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "insert into t_conta (nm_conta, agencia, t_banco_cd_banco, t_usuario_cd_usuario) values(?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, conta.getNm_conta());
        ps.setInt(2, conta.getAgencia());
        ps.setInt(3, conta.getCd_banco());
        ps.setInt(4, conta.getCd_usuraio());

        ps.execute();
    }

    //METODO GETALL DA TABELA CONTA

    public List<Conta> listarConta() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_conta order by nm_conta";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Conta> listarConta = new ArrayList<>();
        while (rs.next()) {
            Conta conta = new Conta();
            conta.setNm_conta(rs.getInt("nm_conta"));
            conta.setAgencia(rs.getInt("agencia"));
            conta.setCd_banco(rs.getInt("t_banco_cd_banco"));
            conta.setCd_usuraio(rs.getInt("T_USUARIO_CD_USUARIO"));
            conta.setCd_resumo(rs.getInt("t_resumo_financeiro_cd_resumo"));
            listarConta.add(conta);
        }
        return listarConta;
    }

}
