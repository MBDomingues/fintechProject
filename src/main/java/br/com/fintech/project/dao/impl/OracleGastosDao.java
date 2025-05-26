package br.com.fintech.project.dao.impl;

import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.dao.GastosDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Gastos;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OracleGastosDao implements GastosDao {

    private Connection conexao;

    @Override
    public void inserirGastos(Gastos gastos) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "INSERT INTO T_GASTOS (CD_GASTO, VL_GASTO, DT_GASTO, DESCRICAO, CATEGORIA, T_USUARIO_CD_USUARIO, T_CONTA_NM_CONTA) VALUES (SEQ_CD_GASTO.NEXTVAL,?,?,?,?,?,null)";
            stmt = conexao.prepareStatement(sql);

            stmt.setDouble(1, gastos.getVl_gastos());
            stmt.setDate(2, Date.valueOf(gastos.getDt_gasto()));
            stmt.setString(3, gastos.getDescricao());
            stmt.setString(4, gastos.getCategoria());
            stmt.setInt(5, gastos.getCd_usuario());
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao inserir gastos");
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
    public void alterarGastos(Gastos gastos) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "UPDATE T_GASTOS SET VL_GASTO = ?, DT_GASTO = ?, DESCRICAO = ?, CATEGORIA = ? WHERE CD_GASTO = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setDouble(1, gastos.getVl_gastos());
            stmt.setDate(2, Date.valueOf(gastos.getDt_gasto()));
            stmt.setString(3, gastos.getDescricao());
            stmt.setString(4, gastos.getCategoria());
            stmt.setInt(5, gastos.getCd_gastos());
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao alterar gastos");
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
    public void excluirGastos(int id) throws DBExeption {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "DELETE FROM T_GASTOS WHERE CD_GASTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao excluir gastos");
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
    public Gastos buscarGastoPorId(int id) throws DBExeption {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Gastos gasto = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_GASTOS WHERE CD_GASTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoGasto = rs.getInt("CD_GASTO");
                int valor = rs.getInt("VL_GASTO");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(rs.getString("DT_GASTO"), formatter);
                LocalDate data = dateTime.toLocalDate(); // Extrai apenas a data
                String descricao = rs.getString("DESCRICAO");
                String categoria = rs.getString("CATEGORIA");
                int codigoUser = rs.getInt("T_USUARIO_CD_USUARIO");
                gasto = new Gastos (codigoGasto, valor, categoria, data, descricao, codigoUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao buscar gastos");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gasto;
    }

    @Override
    public List<Gastos> listarGastos(int codigo) throws DBExeption {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Gastos> gastos = new ArrayList<>();

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_GASTOS where t_usuario_cd_usuario = ? order by dt_gasto";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoGasto = rs.getInt("CD_GASTO");
                int valor = rs.getInt("VL_GASTO");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(rs.getString("DT_GASTO"), formatter);
                LocalDate data = dateTime.toLocalDate(); // Extrai apenas a data
                String descricao = rs.getString("DESCRICAO");
                String categoria = rs.getString("CATEGORIA");
                Gastos gasto =  new Gastos (codigoGasto, valor, categoria, data, descricao, codigo);
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao listar gastos");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gastos;
    }
}
