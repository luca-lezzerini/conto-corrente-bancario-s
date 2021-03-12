package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListaClientiDto {
    
    private List<Cliente> listaClienti;

    public ListaClientiDto() {
    }

    public ListaClientiDto(List<Cliente> clienti) {
        this.listaClienti = clienti;
    }

    public List<Cliente> getClienti() {
        return listaClienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.listaClienti = clienti;
    }

    @Override
    public String toString() {
        return "ListaClientiDto{" + "clienti=" + listaClienti + '}';
    }
 
    
    
    
    
    
    
}
