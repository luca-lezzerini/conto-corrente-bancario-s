/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;

public class MovimentoCpDto {

    MovimentiContoPrestito movimentoCp;
    ContoPrestito contoPrestito;

    public MovimentoCpDto() {
    }

    public MovimentoCpDto(MovimentiContoPrestito movimentoCp, ContoPrestito contoPrestito) {
        this.movimentoCp = movimentoCp;
        this.contoPrestito = contoPrestito;
    }

    public MovimentiContoPrestito getMovimentoCp() {
        return movimentoCp;
    }

    public void setMovimentoCp(MovimentiContoPrestito movimentoCp) {
        this.movimentoCp = movimentoCp;
    }

    public ContoPrestito getContoPrestito() {
        return contoPrestito;
    }

    public void setContoPrestito(ContoPrestito contoPrestito) {
        this.contoPrestito = contoPrestito;
    }

}
