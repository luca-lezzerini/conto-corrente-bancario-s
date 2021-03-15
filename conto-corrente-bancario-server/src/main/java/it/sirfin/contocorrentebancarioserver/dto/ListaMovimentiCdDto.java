package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import java.util.List;

public class ListaMovimentiCdDto {

    private List<MovimentiContoDeposito> listaMovimentiCd;

    public ListaMovimentiCdDto() {
    }

    public ListaMovimentiCdDto(List<MovimentiContoDeposito> listaMovimentiCd) {
        this.listaMovimentiCd = listaMovimentiCd;
    }

    public List<MovimentiContoDeposito> getListaMovimentiCd() {
        return listaMovimentiCd;
    }

    public void setListaMovimentiCd(List<MovimentiContoDeposito> listaMovimentiCd) {
        this.listaMovimentiCd = listaMovimentiCd;
    }

    @Override
    public String toString() {
        return "ListaMovimentiCdDto{" + "listaMovimentiCd=" + listaMovimentiCd + '}';
    }

}
