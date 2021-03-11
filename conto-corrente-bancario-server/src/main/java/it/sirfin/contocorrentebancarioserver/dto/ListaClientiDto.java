package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListaClientiDto {
    
    private List<Cliente> clienti;

    public ListaClientiDto() {
    }

    public ListaClientiDto(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    @Override
    public String toString() {
        return "ListaClientiDto{" + "clienti=" + clienti + '}';
    }
 
    
    
    
    
    
    
}
