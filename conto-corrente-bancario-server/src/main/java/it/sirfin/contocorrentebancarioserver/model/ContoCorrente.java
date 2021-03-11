/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

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
public class ContoCorrente {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String numeroConto;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;
    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private Set<MovimentiContoCorrente> contiCorrente;

    public ContoCorrente() {
    }

    public ContoCorrente(String numeroConto, Cliente cliente) {
        this.numeroConto = numeroConto;
        this.cliente = cliente;
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

    public Set<MovimentiContoCorrente> getContiCorrente() {
        if (contiCorrente == null) {
            contiCorrente = new HashSet<>();
        }
        return contiCorrente;
    }

    public void setContiCorrente(Set<MovimentiContoCorrente> contiCorrente) {
        if (contiCorrente == null) {
            contiCorrente = new HashSet<>();
        }
        this.contiCorrente = contiCorrente;
    }

}
