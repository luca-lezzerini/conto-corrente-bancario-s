/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import java.util.List;


public class ListaMovimentiCpDto {
   
    List<MovimentiContoPrestito> listaMovimentiCp;

    public ListaMovimentiCpDto() {
    }

    public ListaMovimentiCpDto(List<MovimentiContoPrestito> listaMovimentiCp) {
        this.listaMovimentiCp = listaMovimentiCp;
    }

    public List<MovimentiContoPrestito> getListaMovimentiCp() {
        return listaMovimentiCp;
    }

    public void setListaMovimentiCp(List<MovimentiContoPrestito> listaMovimentiCp) {
        this.listaMovimentiCp = listaMovimentiCp;
    }

    @Override
    public String toString() {
        return "ListaMovimentiCpDto{" + "listaMovimentiCp=" + listaMovimentiCp + '}';
    }
    
    
}
