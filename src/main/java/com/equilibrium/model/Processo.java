package com.equilibrium.model;

import java.util.Date;

public class Processo {

    private int id;

    private int tipoProcessoId;

    private String numero;

    private Date dataEntrada;

    private String objetivo;

    private  double valorRecurso;

    private TipoProcesso tipoProcesso;

    public TipoProcesso getTipoProcesso() {return tipoProcesso;}

    public void setTipoProcesso(TipoProcesso tipoProcesso) {this.tipoProcesso = tipoProcesso; }

    public int getTipoProcessoId() {
        return tipoProcessoId;
    }

    public void setTipoProcessoId(int tipoProcessoId) {
        this.tipoProcessoId = tipoProcessoId;
    }

    public double getValorRecurso() {
        return valorRecurso;
    }

    public void setValorRecurso(double valorRecurso) {
        this.valorRecurso = valorRecurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

}
