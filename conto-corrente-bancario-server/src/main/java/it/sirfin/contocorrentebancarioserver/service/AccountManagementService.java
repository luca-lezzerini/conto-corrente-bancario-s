package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;

public interface AccountManagementService {

    ListaContiCorrenteDto aggiungiCc(ContoCorrente cc);

    ListaContiCorrenteDto eliminaCc(ContoCorrente cc);

    ContoCorrenteDto modificaCc(ContoCorrente cc);
    
    ListaContiCorrenteDto confermaCc(ContoCorrente cc);
    
}
