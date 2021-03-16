package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import java.util.Set;

public class ListaMovimentiCdDto {

    Set<MovimentiContoDeposito> listaMovimentiCd;

    public ListaMovimentiCdDto() {
    }

    public ListaMovimentiCdDto(Set<MovimentiContoDeposito> listaMovimentiCd) {
        this.listaMovimentiCd = listaMovimentiCd;
    }

    public Set<MovimentiContoDeposito> getListaMovimentiCd() {
        return listaMovimentiCd;
    }

    public void setListaMovimentiCd(Set<MovimentiContoDeposito> listaMovimentiCd) {
        this.listaMovimentiCd = listaMovimentiCd;
    }

    @Override
    public String toString() {
        return "ListaMovimentiCdDto{" + "listaMovimentiCd=" + listaMovimentiCd + '}';
    }
}