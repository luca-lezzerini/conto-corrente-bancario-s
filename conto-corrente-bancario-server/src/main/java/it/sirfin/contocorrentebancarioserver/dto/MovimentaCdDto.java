/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;

/**
 *
 * @author Palo
 */
public class MovimentaCdDto {

    private ContoDeposito contoDeposito;
    private MovimentiContoDeposito movimentoCd;

    public MovimentaCdDto() {
    }

    public MovimentaCdDto(ContoDeposito contoDeposito, MovimentiContoDeposito movimentoCd) {
        this.contoDeposito = contoDeposito;
        this.movimentoCd = movimentoCd;
    }

    public ContoDeposito getContoDeposito() {
        return contoDeposito;
    }

    public void setContoDeposito(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    public MovimentiContoDeposito getMovimentoCd() {
        return movimentoCd;
    }

    public void setMovimentoCd(MovimentiContoDeposito movimentoCd) {
        this.movimentoCd = movimentoCd;
    }

    @Override
    public String toString() {
        return "MovimentaCdDto{" + "contoDeposito=" + contoDeposito + ", movimentoCd=" + movimentoCd + '}';
    }

}
