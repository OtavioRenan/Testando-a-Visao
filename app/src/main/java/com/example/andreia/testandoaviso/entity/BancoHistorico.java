package com.example.andreia.testandoaviso.entity;


public class BancoHistorico {

    private int letra_grande_erro;
    private int letra_grande_acerto;
    private int letra_pequena_erro;
    private int letra_pequena_acerto;
    private int pontos_erro;
    private int pontos_acerto;

    private int total_Erro;
    private int total_Acerto;

    private Integer _id;

    public int getLetra_grande_erro() {
        return letra_grande_erro;
    }

    public void setLetra_grande_erro(int letra_grande_erro) {
        this.letra_grande_erro = letra_grande_erro;
    }

    public int getLetra_grande_acerto() {
        return letra_grande_acerto;
    }

    public void setLetra_grande_acerto(int letra_grande_acerto) {
        this.letra_grande_acerto = letra_grande_acerto;
    }

    public int getLetra_pequena_erro() {
        return letra_pequena_erro;
    }

    public void setLetra_pequena_erro(int letra_pequena_erro) {
        this.letra_pequena_erro = letra_pequena_erro;
    }

    public int getLetra_pequena_acerto() {
        return letra_pequena_acerto;
    }

    public void setLetra_pequena_acerto(int letra_pequena_acerto) {
        this.letra_pequena_acerto = letra_pequena_acerto;
    }

    public int getPontos_erro() {
        return pontos_erro;
    }

    public void setPontos_erro(int pontos_erro) {
        this.pontos_erro = pontos_erro;
    }

    public int getPontos_acerto() {
        return pontos_acerto;
    }

    public void setPontos_acerto(int pontos_acerto) {
        this.pontos_acerto = pontos_acerto;
    }

    public int getTotal_Erro() {
        return total_Erro;
    }

    public void setTotal_Erro(int total_Erro) {
        this.total_Erro = total_Erro;
    }

    public int getTotal_Acerto() {
        return total_Acerto;
    }

    public void setTotal_Acerto(int total_Acerto) {
        this.total_Acerto = total_Acerto;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "BancoHistorico{" +
                "letra_grande_erro=" + letra_grande_erro +
                ", letra_grande_acerto=" + letra_grande_acerto +
                ", letra_pequena_erro=" + letra_pequena_erro +
                ", letra_pequena_acerto=" + letra_pequena_acerto +
                ", pontos_erro=" + pontos_erro +
                ", pontos_acerto=" + pontos_acerto +
                ", total_Erro=" + total_Erro +
                ", total_Acerto=" + total_Acerto +
                ", _id=" + _id +
                '}';
    }
}
