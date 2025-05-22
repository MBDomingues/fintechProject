package br.com.fintech.project.dao.impl;

import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.dao.UsuarioDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleUsuarioDao implements UsuarioDao {

    private Connection conexao;

    @Override
    public void cadastrarUsuario(Usuario usuario) throws DBExeption {
        Long proximoIdUsuario = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtEmail = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            // 1. Pega o próximo valor da sequência manualmente
            Statement seqStmt = conexao.createStatement();
            ResultSet rs = seqStmt.executeQuery("SELECT SEQ_CD_USUARIO.NEXTVAL FROM DUAL");
            if (rs.next()) {
                proximoIdUsuario = rs.getLong(1);
            }

            // 2. Insere o usuário com o ID manual
            String sqlUsuario = "INSERT INTO t_usuario (cd_usuario, nom_usuario, senha) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sqlUsuario);
            stmt.setLong(1, proximoIdUsuario);
            stmt.setString(2, usuario.getName());
            stmt.setString(3, usuario.getPassword());
            stmt.executeUpdate();

            // 3. Insere o email associado ao mesmo usuário
            String sqlEmail = "INSERT INTO t_email (cd_email, nom_email, tipo_email, cd_usuario) " +
                    "VALUES (SEQ_CD_EMAIL.NEXTVAL, ?, ?, ?)";
            stmtEmail = conexao.prepareStatement(sqlEmail);
            stmtEmail.setString(1, usuario.getNom_email());
            stmtEmail.setString(2, usuario.getTipo_email());
            stmtEmail.setLong(3, proximoIdUsuario);
            stmtEmail.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao inserir usuário e email");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (stmtEmail != null) stmtEmail.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Usuario> listarUsuarios() throws DBExeption {
       PreparedStatement stmt = null;
       List<Usuario> usuarios = new ArrayList<>();
       ResultSet rs = null;

       try {
           conexao = ConnectionManager.getConnectionManager();
           String sql = "select * from t_usuario order by cd_usuario";

           stmt = conexao.prepareStatement(sql);
           rs = stmt.executeQuery();

//           Percorre todos os registros
           while (rs.next()) {
               int codigo = rs.getInt("cd_usuario");
               String nome = rs.getString("nom_usuario");
               String senha = rs.getString("senha");
                Usuario usuario = new Usuario(codigo, nome, senha, 0, null, null);
               usuarios.add(usuario);
           }
       } catch (SQLException e) {
           e.printStackTrace();
           throw new DBExeption("Erro ao listar usuarios");
       } finally {
           try {
               conexao.close();
               stmt.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return usuarios;
       }
    }

    @Override
    public void alterarUsuario(Usuario usuario) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            String sql = "update t_usuario set nom_usuario=?, senha=? where nom_usuario=?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getPassword());
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao alterar usuario");
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e)  {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void excluirUsuario(String nome) throws DBExeption {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "delete from t_usuario where nom_usuario=?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,  nome);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao excluir usuario");
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Usuario buscarUsuarioPoremail(String email) throws DBExeption {

        PreparedStatement stmt = null;
        PreparedStatement stmtEmail = null;
        ResultSet rs = null;
        ResultSet rsEmail = null;
        Usuario usuario = null;
        int codigoUser = 0;
        String senha = null;
        String nom_email = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sqlEmail = "select * from t_email where nom_email = ?";
            stmtEmail = conexao.prepareStatement(sqlEmail);
            stmtEmail.setString(1, email);
            rsEmail = stmtEmail.executeQuery();
            if (rsEmail.next()) {
                nom_email = rsEmail.getString("nom_email");
                codigoUser = rsEmail.getInt("cd_usuario");
            }


            String sqlUsuario = "select * from t_usuario where cd_usuario = ?";
            stmt = conexao.prepareStatement(sqlUsuario);
            stmt.setInt(1, codigoUser);
            rs = stmt.executeQuery();
            if (rs.next()) {
                senha = rs.getString("senha");
            }

            usuario = new Usuario(codigoUser, null, senha, 0, nom_email, null);

        } catch (SQLException e)  {
            e.printStackTrace();
            throw new DBExeption("Erro ao buscar usuario");
        } finally {
            try {
                stmt.close();
                conexao.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
