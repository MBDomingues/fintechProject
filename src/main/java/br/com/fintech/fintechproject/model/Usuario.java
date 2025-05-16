package br.com.fintech.fintechproject.model;

import br.com.fintech.fintechproject.dao.impl.OracleUsuarioDao;

import java.sql.SQLException;
import java.util.Scanner;

//CLASSE DA TABELA USUÁRIO
public class Usuario {

    //VARIÁVEIS
    private int cd_user;

    private String name;

    private String password;

    //CONSTRUTOR
    public Usuario(int cd_user, String name, String password) {
        this.cd_user = cd_user;
        this.name = name;
        this.password = password;
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

    public void cadastro () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.next();
        System.out.println("Digite sua senha: ");
        String senha = sc.next();


        OracleUsuarioDao novoCadastro = new OracleUsuarioDao(nome, senha);
        try {
            novoCadastro.logar();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
