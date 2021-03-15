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
public class ContoPrestito implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String codice;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "contoPrestito")
    @JsonIgnore
    private Set<MovimentiContoPrestito> MovimentiContoPrestito;

    public ContoPrestito() {
    }

    public ContoPrestito(String codice) {
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

}
