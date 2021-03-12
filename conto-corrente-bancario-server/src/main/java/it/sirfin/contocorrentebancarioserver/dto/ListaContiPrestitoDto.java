package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import java.util.List;


public class ListaContiPrestitoDto {
    
    private List<ContoPrestito> listaContiPrestito;

    public ListaContiPrestitoDto() {
    }

    public ListaContiPrestitoDto(List<ContoPrestito> listaContiPrestito) {
        this.listaContiPrestito = listaContiPrestito;
    }

    public List<ContoPrestito> getListaContiPrestito() {
        return listaContiPrestito;
    }

    public void setListaContiPrestito(List<ContoPrestito> listaContiPrestito) {
        this.listaContiPrestito = listaContiPrestito;
    }

    @Override
    public String toString() {
        return "ListaContiPrestitoDto{" + "listaContiPrestito=" + listaContiPrestito + '}';
    }
}
