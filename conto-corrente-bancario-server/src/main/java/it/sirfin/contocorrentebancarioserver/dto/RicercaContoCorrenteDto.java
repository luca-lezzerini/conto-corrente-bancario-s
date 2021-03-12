/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

/**
 *
 * @author Palo
 */
public class RicercaContoCorrenteDto {

    private String codiceEsatto;

    public RicercaContoCorrenteDto() {
    }

    public RicercaContoCorrenteDto(String codiceEsatto) {
        this.codiceEsatto = codiceEsatto;
    }

    public String getCodiceEsatto() {
        return codiceEsatto;
    }

    public void setCodiceEsatto(String codiceEsatto) {
        this.codiceEsatto = codiceEsatto;
    }

    @Override
    public String toString() {
        return "RicercaContoCorrenteDto{" + "codiceEsatto=" + codiceEsatto + '}';
    }
}
