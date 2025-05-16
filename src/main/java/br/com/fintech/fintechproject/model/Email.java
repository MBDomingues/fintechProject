package br.com.fintech.fintechproject.model;

//CLASSE DA TABELA E-MAIL
public class Email {

    //VARIÁVEIS
    private int cd_email;
    private String nom_email;
    private String tipo_email;
    private int cd_usuario;

    //GETTERS AND SETTERS
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

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public String getTipo_email() {
        return tipo_email;
    }

    public void setTipo_email(String tipo_email) {
        this.tipo_email = tipo_email;
    }

    //CONSTRUTOR
    public Email(int cd_email, String nom_email, int cd_usuario, String tipo_email) {
        this.cd_email = cd_email;
        this.nom_email = nom_email;
        this.cd_usuario = cd_usuario;
        this.tipo_email = tipo_email;
    }

    //CONSTRUTOR PADRÃO
    public Email() {}
}
