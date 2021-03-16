/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import java.util.Set;

public class RitMovimentiCdDto {

    private ContoDeposito contoDeposito;
    private Set<MovimentiContoDeposito> movimentiContoDeposito;

    public RitMovimentiCdDto() {
    }

    public RitMovimentiCdDto(ContoDeposito contoDeposito, Set<MovimentiContoDeposito> movimentiContoDeposito) {
        this.contoDeposito = contoDeposito;
        this.movimentiContoDeposito = movimentiContoDeposito;
    }

    public ContoDeposito getContoDeposito() {
        return contoDeposito;
    }

    public void setContoDeposito(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    public Set<MovimentiContoDeposito> getMovimentiContoDeposito() {
        return movimentiContoDeposito;
    }

    public void setMovimentiContoDeposito(Set<MovimentiContoDeposito> movimentiContoDeposito) {
        this.movimentiContoDeposito = movimentiContoDeposito;
    }

    @Override
    public String toString() {
        return "RitMovimentiCdDto{" + "contoDeposito=" + contoDeposito + ", movimentiContoDeposito=" + movimentiContoDeposito + '}';
    }

}
