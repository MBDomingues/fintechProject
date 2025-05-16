package br.com.fintech.fintechproject.dao.impl;

//IMPORTS
import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE GASTOSDAO DA TABELA DAO
public class OracleGastosDao {

    private Gastos gastos;

    //CONSTRUTOR
    public OracleGastosDao(Gastos gastos) {
        this.gastos = gastos;
    }

    //COSNTRUTOR PADRÃO
    public OracleGastosDao() {}

    //GETTER AND SETTER
    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }

    //METODO PARA CADASTRAR DADOS NA TABELA GASTOS

    public void cadastrarGastos () throws SQLException {

        Connection vonnection = ConnectionFactory.getConnection();

        String sql = "insert into t_gastos (cd_gasto, vl_gastos, categoria, dt_gasto, descricao, t_conta_nm_conta, t_conta_t_usuario_cd_usuario) values (?,?,?,?,?,?,?)";

        PreparedStatement ps = vonnection.prepareStatement(sql);

        ps.setInt(1, gastos.getCd_gastos());
        ps.setDouble(2, gastos.getVl_gastos());
        ps.setString(3, gastos.getCategoria());
        ps.setString(4, gastos.getDt_gasto());
        ps.setString(5, gastos.getDescricao());
        ps.setInt(6, gastos.getNm_conta());
        ps.setInt(7, gastos.getCd_usuario());

        ps.executeUpdate();
    }
    //METODO PARA LISTAR OS DADOS DA TABELA GASTOS
    public List<Gastos> listargastos() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_gastos order by cd_gasto";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Gastos> listarGastos = new ArrayList<>();
        while (rs.next()) {
            Gastos gastos = new Gastos();
            gastos.setCd_gastos(rs.getInt("cd_gasto"));
            gastos.setVl_gastos(rs.getDouble("vl_gastos"));
            gastos.setCategoria(rs.getString("categoria"));
            gastos.setDt_gasto(rs.getString("dt_gasto"));
            gastos.setDescricao(rs.getString("descricao"));
            gastos.setNm_conta(rs.getInt("t_conta_nm_conta"));
            gastos.setCd_usuario(rs.getInt("t_conta_t_usuario_cd_usuario"));

            listarGastos.add(gastos);
        }
        return listarGastos;
    }
}
