/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;

/**
 *
 * @author Palo
 */
public class ContoCorrenteDto {

    private ContoCorrente contoCorrente;

    public ContoCorrenteDto() {
    }

    public ContoCorrenteDto(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    public ContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    @Override
    public String toString() {
        return "ContoCorrenteDto{" + "contoCorrente=" + contoCorrente + '}';
    }

}
