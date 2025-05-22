package br.com.fintech.fintechproject.dao.impl;

import br.com.fintech.fintechproject.model.Usuario;
import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.dao.UsuarioDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public void inserirUsuario(Usuario usuario) throws DBExeption {
        // Implementar futuramente, se necessário
    }

    @Override
    public java.util.List<Usuario> listarUsuarios() throws DBExeption {
        return null;
    }

    @Override
    public void alterarUsuario(Usuario usuario) throws DBExeption {
        // Implementar futuramente, se necessário
    }

    @Override
    public void excluirUsuario(Usuario usuario) throws DBExeption {
        // Implementar futuramente, se necessário
    }

    @Override
    public Usuario buscarUsuarioPorId(int id) throws DBExeption {
        return null;
    }

    public Usuario validarLogin(String name, String password) throws DBExeption {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM T_USUARIO WHERE NAME = ? AND PASSWORD = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCd_user(rs.getInt("CD_USER"));
                usuario.setName(rs.getString("NAME"));
                usuario.setPassword(rs.getString("PASSWORD"));
            }

        } catch (Exception e) {
            throw new DBExeption("Erro ao validar login", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }
}
