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
public class ContoDeposito implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String codice;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "contoDeposito")
    @JsonIgnore
    private Set<MovimentiContoDeposito> movimentiContoDeposito;

    public ContoDeposito() {
    }

    public ContoDeposito(String codice) {
        this.codice = codice;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @JsonIgnore
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

    @Override
    public String toString() {
        return "ContoDeposito{" + "id=" + id + ", codice=" + codice
                + ", cliente=" + cliente.getId() + cliente.getNome() + cliente.getCognome()
                + ", movimentiContoDeposito=" + movimentiContoDeposito + '}';
    }

}
