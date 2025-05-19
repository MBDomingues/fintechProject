package br.com.fintech.project.model;

//CLASSE DA TABELA GASTOS
public class Gastos {

    private int cd_gastos;
    private double vl_gastos;
    private String categoria;
    private String dt_gasto;
    private String descricao;
    private int nm_conta;
    private int cd_usuario;

    //CONSTRUTOR
    public Gastos(int cd_gastos, double vl_gastos, String categoria, String dt_gasto, String descricao, int nm_conta, int cd_usuario) {
        this.cd_gastos = cd_gastos;
        this.vl_gastos = vl_gastos;
        this.categoria = categoria;
        this.dt_gasto = dt_gasto;
        this.descricao = descricao;
        this.nm_conta = nm_conta;
        this.cd_usuario = cd_usuario;
    }

    //CONSTRUTOR PADRÃO
    public Gastos() {}

    //GETTERS AND SETTERS

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCd_gastos() {
        return cd_gastos;
    }

    public void setCd_gastos(int cd_gastos) {
        this.cd_gastos = cd_gastos;
    }

    public double getVl_gastos() {
        return vl_gastos;
    }

    public void setVl_gastos(double vl_gastos) {
        this.vl_gastos = vl_gastos;
    }

    public String getDt_gasto() {
        return dt_gasto;
    }

    public void setDt_gasto(String dt_gasto) {
        this.dt_gasto = dt_gasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(int nm_conta) {
        this.nm_conta = nm_conta;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
}

