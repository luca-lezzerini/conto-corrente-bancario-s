/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import java.util.List;

public class ListaContiDepositoDto {

    List<ContoDeposito> listaConti;

    public ListaContiDepositoDto() {
    }

    public ListaContiDepositoDto(List<ContoDeposito> listaConti) {
        this.listaConti = listaConti;
    }

    public List<ContoDeposito> getListaConti() {
        return listaConti;
    }

    public void setListaConti(List<ContoDeposito> listaConti) {
        this.listaConti = listaConti;
    }

    @Override
    public String toString() {
        return "ListaContiDepositoDto{" + "listaConti=" + listaConti + '}';
    }
    
    

}
