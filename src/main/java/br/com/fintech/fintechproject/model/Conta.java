package br.com.fintech.fintechproject.model;

//CLASSE DA TABELA CONTA
public class Conta {

    //VARIÁVEIS DA TABELA CONTA
    private int nm_conta;
    private int agencia;
    private int cd_banco;
    private int cd_usuraio;
    private int cd_resumo;

    //CONSTRUTOR
    public Conta(int agencia, int cd_banco, int cd_usuraio, int cd_resumo, int nm_conta) {
        this.agencia = agencia;
        this.cd_banco = cd_banco;
        this.cd_usuraio = cd_usuraio;
        this.cd_resumo = cd_resumo;
        this.nm_conta = nm_conta;
    }

    //CONSTRUTOR PADRÃO
    public Conta() {}

    //GETTERS AND SETTERS

    public int getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(int nm_conta) {
        this.nm_conta = nm_conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getCd_banco() {
        return cd_banco;
    }

    public void setCd_banco(int cd_banco) {
        this.cd_banco = cd_banco;
    }

    public int getCd_usuraio() {
        return cd_usuraio;
    }

    public void setCd_usuraio(int cd_usuraio) {
        this.cd_usuraio = cd_usuraio;
    }

    public int getCd_resumo() {
        return cd_resumo;
    }

    public void setCd_resumo(int cd_resumo) {
        this.cd_resumo = cd_resumo;
    }
}
