package br.com.fintech.project.model;

import java.time.LocalDate;
import java.util.Date;

//CLASSE DA TABELA GASTOS
public class Gastos {

    private int cd_gastos;
    private double vl_gastos;
    private String categoria;
    private LocalDate dt_gasto;
    private String descricao;
    private int cd_usuario;

    //CONSTRUTOR
    public Gastos(int cd_gastos, double vl_gastos, String categoria, LocalDate dt_gasto, String descricao, int cd_usuario) {
        this.cd_gastos = cd_gastos;
        this.vl_gastos = vl_gastos;
        this.categoria = categoria;
        this.dt_gasto = dt_gasto;
        this.descricao = descricao;
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

    public LocalDate getDt_gasto() {
        return dt_gasto;
    }

    public void setDt_gasto(LocalDate dt_gasto) {
        this.dt_gasto = dt_gasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
}

