package br.com.fintech.project.dao.impl;

import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.dao.MetasDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Metas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            stmt.setString(2, metas.getDt_alvo());
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

            String sql = "UPDATE T_METAS SET VL_ALVO = ?, DT_ALVO = ?, DESCRICAO = ?, VL_ATUAL = ?, WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, metas.getVl_alvo());
            stmt.setString(2, metas.getDt_alvo());
            stmt.setString(3, metas.getDescricao());
            stmt.setDouble(4, metas.getVl_atual());

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
    public void excluirMeta(Metas metas) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "DELETE FROM T_METAS WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, metas.getCd_meta());
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
    public List<Metas> listarMetas() throws DBExeption {
        PreparedStatement stmt = null;
        List<Metas>  metas = new ArrayList<>();
        ResultSet rs = null;
        Metas metasAux = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_METAS WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, metasAux.getCd_meta());
            stmt.executeUpdate();
            rs = stmt.executeQuery();

            while (rs.next()) {
                metasAux = new Metas();
                metasAux.setCd_meta(rs.getInt("CD_META"));
                metasAux.setVl_alvo(rs.getDouble("VL_ALVO"));
                metasAux.setDt_alvo(rs.getString("DT_ALVO"));
                metasAux.setDescricao(rs.getString("DESCRICAO"));
                metasAux.setVl_atual(rs.getDouble("VL_ATUAL"));
                metas.add(metasAux);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao listar metas");
        }
        return  metas;
    }

    @Override
    public Metas buscarMetasPorCodigoUsuario(int codigo) throws DBExeption {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Metas metas  = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "SELECT * FROM T_METAS WHERE CD_META = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                metas = new Metas();
                metas.setCd_meta(rs.getInt("cd_meta"));
                metas.setDescricao(rs.getString("descricao"));
                metas.setVl_alvo(rs.getDouble("vl_alvo"));
                metas.setDt_alvo(rs.getString("dt_alvo"));
                metas.setVl_atual(rs.getDouble("vl_atual"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("erro ao buscar metas");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {}
        }
        return metas;
    }
}
