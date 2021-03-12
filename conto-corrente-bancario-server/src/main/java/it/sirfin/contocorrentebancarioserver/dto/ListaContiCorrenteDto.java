/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import java.util.List;

/**
 *
 * @author Palo
 */
public class ListaContiCorrenteDto {

    private List<ContoCorrente> listaContiCorrente;

    public ListaContiCorrenteDto() {
    }

    public ListaContiCorrenteDto(List<ContoCorrente> listaContiCorrente) {
        this.listaContiCorrente = listaContiCorrente;
    }

    public List<ContoCorrente> getListaContiCorrente() {
        return listaContiCorrente;
    }

    public void setListaContiCorrente(List<ContoCorrente> listaContiCorrente) {
        this.listaContiCorrente = listaContiCorrente;
    }

    @Override
    public String toString() {
        return "ListaContiCorrente{" + "listaContiCorrente=" + listaContiCorrente + '}';
    }

}
