package br.com.fintech.fintechproject.model;

//CLASSE DA TABELA BANCO
public class Banco {

    //VARIÁVEIS
    private int cd_banco;
    private String nm_banco;

    //CONSTRUTOR
    public Banco(int cd_banco, String nm_banco) {
        this.cd_banco = cd_banco;
        this.nm_banco = nm_banco;
    }

    //CONSTRUTOR PADRÃ0
    public Banco() {}

    //GETTERS AND SETTERS
    public int getCd_banco() {
        return cd_banco;
    }

    public void setCd_banco(int cd_banco) {
        this.cd_banco = cd_banco;
    }

    public String getNm_banco() {
        return nm_banco;
    }

    public void setNm_banco(String nm_banco) {
        this.nm_banco = nm_banco;
    }
}
