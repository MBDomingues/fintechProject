package br.com.fintech.project.model;


//CLASSE DA TABELA RENDA
public class Renda {

    //VARIÁVEIS
    private int cd_renda;
    private double vl_renda;
    private String frequencia;
    private String tp_renda;
    private int cd_usuario;


    //CONSTRUTOR PADRÃO
    public Renda() {}

    public Renda(int cdRenda, double vlRenda, String frequencia, String tp_renda, int cdUsuario) {
        this.cd_renda = cdRenda;
        this.vl_renda = vlRenda;
        this.frequencia = frequencia;
        this.tp_renda = tp_renda;
        this.cd_usuario = cdUsuario;
    }

    //GETTERS AND SETTERS
    public long getVl_renda() {
        return (long) vl_renda;
    }

    public void setVl_renda(long vl_renda) {
        this.vl_renda = vl_renda;
    }

    public int getCd_renda() {
        return cd_renda;
    }

    public void setCd_renda(int cd_renda) {
        this.cd_renda = cd_renda;
    }

    public String getTp_renda() {
        return tp_renda;
    }

    public void setTp_renda(String tp_renda) {
        this.tp_renda = tp_renda;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }


    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
}
