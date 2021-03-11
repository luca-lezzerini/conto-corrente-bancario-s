/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marco
 */
@Entity
public class MovimentiContoDeposito {
      @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate dataMov;
    @Column
    private String tipoMovimento;
    @Column
    private double importo;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ContoDeposito contoDeposito;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ContoCorrente contoCorrente;

    public MovimentiContoDeposito(LocalDate dataMov, String tipoMovimento, double importo) {
        this.dataMov = dataMov;
        this.tipoMovimento = tipoMovimento;
        this.importo = importo;
    }

    public MovimentiContoDeposito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMov() {
        return dataMov;
    }

    public void setDataMov(LocalDate dataMov) {
        this.dataMov = dataMov;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public ContoDeposito getContoDeposito() {
        return contoDeposito;
    }

    public void setContoDeposito(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    public ContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }
    
    
    
   
    
}
