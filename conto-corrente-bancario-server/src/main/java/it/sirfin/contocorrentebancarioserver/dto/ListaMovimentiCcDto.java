/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;
import java.util.Set;

/**
 *
 * @author marco
 */
public class ListaMovimentiCcDto {

    Set<MovimentiContoCorrente> listaMovimentiCc;

    public ListaMovimentiCcDto() {
    }

    public ListaMovimentiCcDto(Set<MovimentiContoCorrente> listaMovimentiCc) {
        this.listaMovimentiCc = listaMovimentiCc;
    }

    public Set<MovimentiContoCorrente> getListaMovimentiCc() {
        return listaMovimentiCc;
    }

    public void setListaMovimentiCc(Set<MovimentiContoCorrente> listaMovimentiCc) {
        this.listaMovimentiCc = listaMovimentiCc;
    }

    @Override
    public String toString() {
        return "ListaMovimentiCcDto{" + "listaMovimentiCc=" + listaMovimentiCc + '}';
    }

}
