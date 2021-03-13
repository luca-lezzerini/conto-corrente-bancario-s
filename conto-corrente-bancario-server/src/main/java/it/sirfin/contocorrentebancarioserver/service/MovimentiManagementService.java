package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;

public interface MovimentiManagementService {

    ListaClientiDto cercaClienteLike(String c);
    
    ListaClientiDto cercaClienteSaldo(String c);

    TuttiContiDto ricercaContiAssociatiCliente(Cliente c);
}
