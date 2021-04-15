package com.example.demo.domain;

import java.util.Date;

public class Dato {
    private Integer idDato;
    private String dato;
    private Date fecha;
    private Integer zonaId;
    private Integer tipodedatoId;
    private String txUser;
    private String txHost;
    private Date txDate;

    public Dato() {
    }

    public Dato(Integer idDato, String dato, Date fecha, Integer zonaId, Integer tipodedatoId, String txUser, String txHost, Date txDate) {
        this.idDato = idDato;
        this.dato = dato;
        this.fecha = fecha;
        this.zonaId = zonaId;
        this.tipodedatoId = tipodedatoId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getZonaId() {
        return zonaId;
    }

    public void setZonaId(Integer zonaId) {
        this.zonaId = zonaId;
    }

    public Integer getTipodedatoId() {
        return tipodedatoId;
    }

    public void setTipodedatoId(Integer tipodedatoId) {
        this.tipodedatoId = tipodedatoId;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}
