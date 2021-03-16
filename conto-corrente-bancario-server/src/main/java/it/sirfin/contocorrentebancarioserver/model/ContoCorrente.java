/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;

    @JsonIgnoreProperties(value = "contoCorrente", allowSetters = true)
//    @JsonIgnore
    @OneToMany(mappedBy = "contoCorrente", fetch = FetchType.LAZY)
    private Set<MovimentiContoCorrente> movimentiContoCorrente;

    @JsonIgnoreProperties(value = "contoCorrente", allowSetters = true)
    @OneToMany(mappedBy = "contoCorrente")
    private Set<MovimentiContoDeposito> movimentiContoDeposito;

    @JsonIgnore
    @OneToMany(mappedBy = "contoCorrente")
    private Set<MovimentiContoPrestito> movimentiContoPrestito;

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
        if (movimentiContoCorrente == null) {
            movimentiContoCorrente = new HashSet<>();
        }
        return movimentiContoCorrente;
    }

    @JsonIgnore
    public void setMovimentiContoCorrente(Set<MovimentiContoCorrente> movimentiContoCorrente) {
        if (movimentiContoCorrente == null) {
            movimentiContoCorrente = new HashSet<>();
        }
        this.movimentiContoCorrente = movimentiContoCorrente;
    }

    public Set<MovimentiContoDeposito> getMovimentiContoDeposito() {
        if (movimentiContoDeposito == null) {
            movimentiContoDeposito = new HashSet<>();
        }
        return movimentiContoDeposito;
    }

    public void setMovimentiContoDeposito(Set<MovimentiContoDeposito> movimentiContoDeposito) {
        if (movimentiContoDeposito == null) {
            movimentiContoDeposito = new HashSet<>();
        }
        this.movimentiContoDeposito = movimentiContoDeposito;
    }

    public Set<MovimentiContoPrestito> getMovimentiContoPrestito() {
        if (movimentiContoPrestito == null) {
            movimentiContoPrestito = new HashSet<>();
        }

        return movimentiContoPrestito;
    }

    public void setMovimentiContoPrestito(Set<MovimentiContoPrestito> movimentiContoPrestito) {
        if (movimentiContoPrestito == null) {
            movimentiContoPrestito = new HashSet<>();
        }
        this.movimentiContoPrestito = movimentiContoPrestito;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" + "id=" + id + ", numeroConto=" + numeroConto + ", cliente=" + cliente.getId() + ", movimentiContoCorrente=" + movimentiContoCorrente + ", movimentiContoDeposito=" + movimentiContoDeposito + ", movimentiContoPrestito=" + movimentiContoPrestito + '}';
    }

   


}
