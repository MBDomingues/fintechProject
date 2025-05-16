package br.com.fintech.fintechproject.dao.impl;

//IMPORTS

import br.com.fintech.fintechproject.dao.factory.ConnectionFactory;
import br.com.fintech.fintechproject.model.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE EMAILDAO DA TABELA EMAIL
public class OracleEmailDao {

    private Email email;

    //CONTRUTOR
    public OracleEmailDao(Email email) {
        this.email = email;
    }

    //CONTRUTOR PADRÃO
    public OracleEmailDao() {}

    //GETTERS AND SETTERS
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    //METODO PARA CADASTRAR DADOS DA TABELA EMAIL
    public void registrarEmail() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "insert into t_email (cd_email, nom_email, tipo_email, cd_usuario) values (?, ?, ?, ?)";

        PreparedStatement ps =  connection.prepareStatement(sql);

        ps.setInt(1, email.getCd_email());
        ps.setString(2, email.getNom_email());
        ps.setString(3, email.getTipo_email());
        ps.setInt(4, email.getCd_usuario());

        ps.executeUpdate();
    }

    //METODO PARA CONSULTAR DADOS DA TABELA EMAIL
    public List<Email> listarEmail() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_email order by cd_email";

        PreparedStatement ps =  connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Email> listarEmail = new ArrayList<>();

        while (rs.next()) {
            Email email = new Email();
            email.setCd_email(rs.getInt("cd_email"));
            email.setNom_email(rs.getString("nom_email"));
            email.setTipo_email(rs.getString("tipo_email"));
            email.setCd_usuario(rs.getInt("cd_usuario"));
            listarEmail.add(email);
        }
        return listarEmail;
    }

}
