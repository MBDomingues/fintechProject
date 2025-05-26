package br.com.fintech.project.dao.impl;

import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Metas;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OracleMetasDao implements MetasDao {

    private Connection conexao;


    @Override
    public void cadastrarMeta(Metas metas) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            String sql = "INSERT INTO T_METAS (CD_META, VL_ALVO, DT_ALVO, DESCRICAO, VL_ATUAL, CD_USUARIO) VALUES (SEQ_CD_META.NEXTVAL,?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, metas.getVl_alvo());
            stmt.setDate(2, Date.valueOf(metas.getDt_alvo()));
            stmt.setString(3, metas.getDescricao());
            stmt.setDouble(4, metas.getVl_atual());
            stmt.setInt(5, metas.getCd_usuario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw  new DBExeption("erro ao cadastrar metas");
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
    public void alterarMeta(Metas metas) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            String sql = "UPDATE T_METAS SET VL_ALVO = ?, DT_ALVO = ?, DESCRICAO = ?, VL_ATUAL = ? WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, metas.getVl_alvo());
            stmt.setDate(2, Date.valueOf(metas.getDt_alvo()));
            stmt.setString(3, metas.getDescricao());
            stmt.setDouble(4, metas.getVl_atual());
            stmt.setInt(5, metas.getCd_meta());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao alterar metas");
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
    public void excluirMeta(int id) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "DELETE FROM T_METAS WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao excluir metas");
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
    public List<Metas> listarMetas(int codigo) throws DBExeption {
        PreparedStatement stmt = null;
        List<Metas>  metas = new ArrayList<>();
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_METAS WHERE CD_USUARIO = ? ORDER BY DT_ALVO";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigoMeta = rs.getInt("CD_META");
                double valor_alvo = rs.getDouble("VL_ALVO");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(rs.getString("DT_ALVO"), formatter);
                LocalDate data = dateTime.toLocalDate(); // Extrai apenas a data
                String desc = rs.getString("DESCRICAO");
                double valor_atual = rs.getDouble("VL_ATUAL");
                Metas meta = new Metas(codigoMeta, valor_alvo, data, desc,valor_atual, codigo);
                metas.add(meta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao listar metas");
        }
        return  metas;
    }

    @Override
    public Metas buscarMetasPorCodigo(int codigo) throws DBExeption {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Metas meta  = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_METAS WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String desc = rs.getString("descricao");
                double valor_alvo = rs.getDouble("vl_alvo");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(rs.getString("DT_ALVO"), formatter);
                LocalDate data = dateTime.toLocalDate(); // Extrai apenas a data
                double valor_atual = rs.getDouble("vl_atual");
                int codigoUser = rs.getInt("cd_usuario");
                meta = new Metas (codigo, valor_alvo, data, desc, valor_atual, codigoUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao buscar metas");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meta;
    }
}
