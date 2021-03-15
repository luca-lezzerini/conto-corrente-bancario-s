/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import java.util.List;
import java.util.Set;

public class ListaMovimentiCpDto {

    Set<MovimentiContoPrestito> listaMovimentiCp;

    public ListaMovimentiCpDto() {
    }

    public ListaMovimentiCpDto(Set<MovimentiContoPrestito> listaMovimentiCp) {
        this.listaMovimentiCp = listaMovimentiCp;
    }

    public Set<MovimentiContoPrestito> getListaMovimentiCp() {
        return listaMovimentiCp;
    }

    public void setListaMovimentiCp(Set<MovimentiContoPrestito> listaMovimentiCp) {
        this.listaMovimentiCp = listaMovimentiCp;
    }

}
