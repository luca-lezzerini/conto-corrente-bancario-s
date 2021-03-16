/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author marco
 */
@Entity
public class ContoCorrente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String numeroConto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "contoCorrente")
    private Set<MovimentiContoCorrente> MovimentiContoCorrente;

    @JsonIgnore
    @OneToMany(mappedBy = "contoCorrente")
    private Set<MovimentiContoDeposito> MovimentiContoDeposito;

    @JsonIgnore
    @OneToMany(mappedBy = "contoCorrente")
    private Set<MovimentiContoPrestito> MovimentiContoPrestito;

    public ContoCorrente() {
    }

    public ContoCorrente(String numeroConto) {
        this.numeroConto = numeroConto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonIgnore
    public Set<MovimentiContoCorrente> getMovimentiContoCorrente() {
        if (MovimentiContoCorrente == null) {
            MovimentiContoCorrente = new HashSet<>();
        }
        return MovimentiContoCorrente;
    }

    @JsonIgnore
    public void setMovimentiContoCorrente(Set<MovimentiContoCorrente> MovimentiContoCorrente) {
        if (MovimentiContoCorrente == null) {
            MovimentiContoCorrente = new HashSet<>();
        }
        this.MovimentiContoCorrente = MovimentiContoCorrente;
    }

    public Set<MovimentiContoDeposito> getMovimentiContoDeposito() {
        if (MovimentiContoDeposito == null) {
            MovimentiContoDeposito = new HashSet<>();
        }
        return MovimentiContoDeposito;
    }

    public void setMovimentiContoDeposito(Set<MovimentiContoDeposito> MovimentiContoDeposito) {
        if (MovimentiContoDeposito == null) {
            MovimentiContoDeposito = new HashSet<>();
        }
        this.MovimentiContoDeposito = MovimentiContoDeposito;
    }

    public Set<MovimentiContoPrestito> getMovimentiContoPrestito() {
        if (MovimentiContoPrestito == null) {
            MovimentiContoPrestito = new HashSet<>();
        }

        return MovimentiContoPrestito;
    }

    public void setMovimentiContoPrestito(Set<MovimentiContoPrestito> MovimentiContoPrestito) {
        if (MovimentiContoPrestito == null) {
            MovimentiContoPrestito = new HashSet<>();
        }
        this.MovimentiContoPrestito = MovimentiContoPrestito;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" + "id=" + id + ", numeroConto=" + numeroConto + ", cliente=" + cliente + ", MovimentiContoCorrente=" + MovimentiContoCorrente + ", MovimentiContoDeposito=" + MovimentiContoDeposito + ", MovimentiContoPrestito=" + MovimentiContoPrestito + '}';
    }

}
