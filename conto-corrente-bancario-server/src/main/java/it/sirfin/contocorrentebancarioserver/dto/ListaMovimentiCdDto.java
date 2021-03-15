package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import java.util.List;

public class ListaMovimentiCdDto {

    private List<ContoDeposito> listaConti;

    public ListaMovimentiCdDto() {
    }

    public ListaMovimentiCdDto(List<ContoDeposito> listaConti) {
        this.listaConti = listaConti;
    }

    public List<ContoDeposito> getListaConti() {
        return listaConti;
    }

    public void setListaConti(List<ContoDeposito> listaConti) {
        this.listaConti = listaConti;
    }

}
