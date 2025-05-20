package br.com.fintech.project.model;

import java.sql.SQLException;
import java.util.Scanner;

//CLASSE DA TABELA USUÁRIO
public class Usuario {

    //VARIÁVEIS
    private int cd_user;

    private String name;

    private String password;

    private int cd_email;

    private String nom_email;

    private String tipo_email;

    //CONSTRUTOR
    public Usuario(int cd_user, String name, String password, int cd_email, String nom_email, String tipo_email) {
        this.cd_user = cd_user;
        this.name = name;
        this.password = password;
        this.cd_email = cd_email;
        this.nom_email = nom_email;
        this.tipo_email = tipo_email;
    }

    //CONSTRUTOR PADRÃO
    public Usuario() {}


    //GETTERS AND SETTERS
    public int getCd_user() {
        return cd_user;
    }

    public void setCd_user(int cd_user) {
        this.cd_user = cd_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCd_email() {
        return cd_email;
    }

    public void setCd_email(int cd_email) {
        this.cd_email = cd_email;
    }

    public String getNom_email() {
        return nom_email;
    }

    public void setNom_email(String nom_email) {
        this.nom_email = nom_email;
    }

    public String getTipo_email() {
        return tipo_email;
    }

    public void setTipo_email(String tipo_email) {
        this.tipo_email = tipo_email;
    }
}
