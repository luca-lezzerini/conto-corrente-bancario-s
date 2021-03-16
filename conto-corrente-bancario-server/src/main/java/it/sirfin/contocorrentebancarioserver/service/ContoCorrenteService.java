package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;

public interface ContoCorrenteService {

    void demo();

    ListaClientiDto aggiungi(Cliente c);

    ListaClientiDto aggiorna();

    ListaClientiDto cancella(Cliente c);
    
    ClienteDto modificaCliente(Cliente c);
    
    ListaClientiDto confermaModificaCliente(Cliente c);
}
