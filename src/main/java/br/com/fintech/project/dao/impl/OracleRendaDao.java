package br.com.fintech.project.dao.impl;

import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.dao.RendaDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Renda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OracleRendaDao implements RendaDao {

    private Connection conexao;

    @Override
    public void inserirRenda(Renda renda) throws DBExeption {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "insert into t_renda (cd_renda, vl_renda, frequencia, tp_renda, cd_usuario) values (SEQ_CD_RENDA.NEXTVAL, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, renda.getVl_renda());
            stmt.setString(2, renda.getFrequencia());
            stmt.setString(3, renda.getTp_renda());
            stmt.setInt(4,renda.getCd_usuario());
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            throw  new DBExeption("erro ao inserir renda",e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void alterarRenda(Renda renda) throws DBExeption {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "update t_renda set vl_renda = ?, frequencia = ?, tp_renda = ? where cd_renda = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, renda.getVl_renda());
            stmt.setString(2, renda.getFrequencia());
            stmt.setString(3, renda.getTp_renda());
            stmt.setInt(4,renda.getCd_renda());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao alterar renda",e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void excluirRenda(int id) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "delete from t_renda where cd_renda = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao deletar renda",e);
        }  finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Renda buscarRendaPorId(int id) throws DBExeption {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Renda renda = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "select * from t_renda where cd_renda = ?";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoRenda = rs.getInt("cd_renda");
                double valorRenda = rs.getDouble("vl_renda");
                String frequencia = rs.getString("frequencia");
                String tipoRenda = rs.getString("tp_renda");
                int codigoUser = rs.getInt("cd_usuario");
                renda = new Renda(codigoRenda, valorRenda, frequencia, tipoRenda, codigoUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao buscar renda",e);
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return renda;
    }

    @Override
    public List<Renda> listarRendas() throws DBExeption {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Renda> rendas = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "select * from t_renda";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoRenda = rs.getInt("cd_renda");
                double valorRenda = rs.getDouble("vl_renda");
                String frequencia = rs.getString("frequencia");
                String tipoRenda = rs.getString("tp_renda");
                int codigoUser = rs.getInt("cd_usuario");
                Renda renda = new Renda(codigoRenda, valorRenda, frequencia, tipoRenda, codigoUser);
                rendas.add(renda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao listar rendas",e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rendas;
    }
}
