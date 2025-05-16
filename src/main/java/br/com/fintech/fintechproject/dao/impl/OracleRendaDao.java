package br.com.fintech.fintechproject.dao.impl;

//IMPORTS

import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Renda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE RENDADAO DA TABELA RENDA
public class OracleRendaDao {

    private Renda renda;

    //CONSTRUTOR
    public OracleRendaDao(Renda renda) {
        this.renda = renda;
    }

    //CONSTRUTOR PADRÃO
    public OracleRendaDao() {}

    //GETTER AND SETTER
    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }

    //METODO PARA CADASTRAR DADOS NA TABELA RENDA
    public void cadastrarRenda() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO T_RENDA (CD_RENDA, VL_RENDA, FREQUENCIA, TP_RENDA, T_CONTA_NM_CONTA,  T_CONTA_T_USUARIO_CD_USUARIO) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, renda.getCd_renda());
        ps.setDouble(2, renda.getVl_renda());
        ps.setString(3, renda.getFrequencia());
        ps.setString(4, renda.getTp_renda());
        ps.setInt(5, renda.getNm_conta());
        ps.setInt(6, renda.getCd_usuario());


        ps.executeUpdate();
    }

    //METODO PARA LISTAR DADOS DA TABELA RENDA
    public List<Renda> listarRenda() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_renda order by cd_renda";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Renda> listarRenda = new ArrayList<>();
        while (rs.next()) {
            Renda renda = new Renda();
            renda.setCd_renda(rs.getInt("CD_RENDA"));
            renda.setVl_renda(rs.getInt("VL_RENDA"));
            renda.setFrequencia(rs.getString("FREQUENCIA"));
            renda.setTp_renda(rs.getString("TP_RENDA"));
            renda.setNm_conta(rs.getInt("T_CONTA_NM_CONTA"));
            renda.setCd_usuario(rs.getInt("T_CONTA_T_USUARIO_CD_USUARIO"));
            listarRenda.add(renda);
        }
        return listarRenda;
    }


}


