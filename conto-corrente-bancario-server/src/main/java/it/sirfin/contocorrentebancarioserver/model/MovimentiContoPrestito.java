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
public class MovimentiContoPrestito {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate dataMov;
    @Column
    private String tipoMovimento;
    @Column
    private double importoMov;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ContoCorrente contoCorrente;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ContoPrestito contoPrestito;

    public MovimentiContoPrestito() {
    }

    public MovimentiContoPrestito(LocalDate dataMov, String tipoMovimento, double importo, ContoCorrente contoCorrente) {
        this.dataMov = dataMov;
        this.tipoMovimento = tipoMovimento;
        this.importoMov = importo;
        this.contoCorrente = contoCorrente;
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

    public double getImportoMov() {
        return importoMov;
    }

    public void setImportoMov(double importoMov) {
        this.importoMov = importoMov;
    }

    public ContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    public ContoPrestito getContoPrestito() {
        return contoPrestito;
    }

    public void setContoPrestito(ContoPrestito contoPrestito) {
        this.contoPrestito = contoPrestito;
    }

    @Override
    public String toString() {
        return "MovimentiContoPrestito{" + "id=" + id + ", tipoMovimento=" + tipoMovimento + ", importoMov=" + importoMov + '}';
    }  
}
