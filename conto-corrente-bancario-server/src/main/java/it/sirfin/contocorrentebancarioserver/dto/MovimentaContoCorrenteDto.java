/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;

/**
 *
 * @author aleur
 */
public class MovimentaContoCorrenteDto {

    MovimentiContoCorrente movimentoCc;
    ContoCorrente contoCorrente;

    public MovimentaContoCorrenteDto() {
    }

    public MovimentaContoCorrenteDto(MovimentiContoCorrente movimentoCc, ContoCorrente contoCorrente) {
        this.movimentoCc = movimentoCc;
        this.contoCorrente = contoCorrente;
    }

    public MovimentiContoCorrente getMovimentoCc() {
        return movimentoCc;
    }

    public void setMovimentoCc(MovimentiContoCorrente movimentoCc) {
        this.movimentoCc = movimentoCc;
    }

    public ContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    @Override
    public String toString() {
        return "MovimentaContoCorrenteDto{" + "movimentoCc=" + movimentoCc + ", contoCorrente=" + contoCorrente + '}';
    }

}
