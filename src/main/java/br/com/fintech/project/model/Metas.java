package br.com.fintech.project.model;

//CLASSE DA TABELA METAS
public class Metas {
    private int cd_meta;
    private double vl_alvo;
    private String dt_alvo;
    private String descricao;
    private double vl_atual;;
    private int cd_usuario;

    //CONSTRUTOR
    public Metas(int cd_meta, double vl_alvo, String dt_alvo, String descricao, double vl_atual, int cd_usuario) {
        this.cd_meta = cd_meta;
        this.vl_alvo = vl_alvo;
        this.dt_alvo = dt_alvo;
        this.descricao = descricao;
        this.vl_atual = vl_atual;
        this.cd_usuario = cd_usuario;
    }

    //CONSTRUTOR PADRÃO
    public Metas() {}

    //GETTERS AND SETTERS
    public int getCd_meta() {
        return cd_meta;
    }

    public void setCd_meta(int cd_meta) {
        this.cd_meta = cd_meta;
    }

    public double getVl_alvo() {
        return vl_alvo;
    }

    public void setVl_alvo(double vl_alvo) {
        this.vl_alvo = vl_alvo;
    }

    public String getDt_alvo() {
        return dt_alvo;
    }

    public void setDt_alvo(String dt_alvo) {
        this.dt_alvo = dt_alvo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVl_atual() {
        return vl_atual;
    }

    public void setVl_atual(double vl_atual) {
        this.vl_atual = vl_atual;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
}
