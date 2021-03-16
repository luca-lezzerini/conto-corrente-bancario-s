/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author marco
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String codiceFiscale;
    @Column
    private String indirizzo;
    @Column
    private String telefono;
    @Column
    private LocalDate dataDiNascita;

    @JsonIgnoreProperties(value = "cliente", allowSetters = true)
    @OneToMany(mappedBy = "cliente")
    private Set<ContoDeposito> contiDeposito;

    @JsonIgnoreProperties(value = "cliente", allowSetters = true)
    @OneToMany(mappedBy = "cliente")
    private Set<ContoCorrente> contiCorrenti;
    
    @JsonIgnoreProperties(value = "cliente", allowSetters = true)
    @OneToMany(mappedBy = "cliente")
    private Set<ContoPrestito> contiPrestito;

    public Cliente(String nome, String cognome, String codiceFiscale, String indirizzo, String telefono, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.dataDiNascita = dataDiNascita;
        
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<ContoDeposito> getContiDeposito() {
        if (contiDeposito == null) {
            contiDeposito = new HashSet<>();
        }
        return contiDeposito;
    }

    public void setContiDeposito(Set<ContoDeposito> contiDeposito) {
        if (contiDeposito == null) {
            contiDeposito = new HashSet<>();
        }
        this.contiDeposito = contiDeposito;
    }

    public Set<ContoCorrente> getContiCorrenti() {
        if (contiCorrenti == null) {
            contiCorrenti = new HashSet<>();
        }
        return contiCorrenti;
    }

    public void setContiCorrenti(Set<ContoCorrente> contiCorrenti) {
        if (contiCorrenti == null) {
            contiCorrenti = new HashSet<>();
        }
        this.contiCorrenti = contiCorrenti;
    }

    public Set<ContoPrestito> getContiPrestito() {
        if (contiPrestito == null) {
            contiPrestito = new HashSet<>();
        }
        return contiPrestito;
    }

    public void setContiPrestito(Set<ContoPrestito> contiPrestito) {
        if (contiPrestito == null) {
            contiPrestito = new HashSet<>();
        }
        this.contiPrestito = contiPrestito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", indirizzo=" + indirizzo + ", telefono=" + telefono + ", dataDiNascita=" + dataDiNascita + ", contiDeposito=" + contiDeposito + ", contiCorrente=" + contiCorrenti + ", contiPrestito=" + contiPrestito + '}';
    }

    
}
