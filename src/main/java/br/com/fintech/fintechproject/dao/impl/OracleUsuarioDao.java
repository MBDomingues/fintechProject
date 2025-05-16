package br.com.fintech.fintechproject.dao.impl;

// IMPORTS

import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE USUARIODAO DA TABELA USUARIO
public class OracleUsuarioDao {

    private Usuario usuario;

    //CONTRUTOR PADRÃO
    public OracleUsuarioDao(String nome, String senha) {
    }

    //CONSTRUTOR
    public OracleUsuarioDao(Usuario usuario) {
        this.usuario = usuario;
    }

    //GETTER AND SETTER
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    //METODO PARA CADASTRAR DADOS DA TABELA USUÁRIO
    public void logar() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "insert into t_usuario (cd_usuario, nom_usuario, senha) values (?, ?, ?)";
        PreparedStatement ps =  connection.prepareStatement(sql);

        ps.setInt(1, usuario.getCd_user());
        ps.setString(2, usuario.getName());
        ps.setString(3, usuario.getPassword());

        ps.executeUpdate();
    }

    //METODO PARA CONSULTAR DADOS DA TABELA USUÁRIO
    public List <Usuario> listarUsuarios() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_usuario order by cd_usuario";

        PreparedStatement ps =  connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Usuario> listaUsuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCd_user(rs.getInt("cd_usuario"));
            usuario.setName(rs.getString("nom_usuario"));
            usuario.setPassword(rs.getString("senha"));
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }
}
