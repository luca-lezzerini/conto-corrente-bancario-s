/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

/**
 *
 * @author aleur
 */
public class MovimentaContoCorrenteDto {
    private String tipoMovimento;
    private String codiceConto;
    private double Importo;

    public MovimentaContoCorrenteDto() {
    }

    public MovimentaContoCorrenteDto(String tipoMovimento, String codiceConto, double Importo) {
        this.tipoMovimento = tipoMovimento;
        this.codiceConto = codiceConto;
        this.Importo = Importo;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getCodiceConto() {
        return codiceConto;
    }

    public void setCodiceConto(String codiceConto) {
        this.codiceConto = codiceConto;
    }

    public double getImporto() {
        return Importo;
    }

    public void setImporto(double Importo) {
        this.Importo = Importo;
    }

    @Override
    public String toString() {
        return "MovimentaContoCorrenteDto{" + "tipoMovimento=" + tipoMovimento + ", codiceConto=" + codiceConto + ", Importo=" + Importo + '}';
    }
    
    
}
