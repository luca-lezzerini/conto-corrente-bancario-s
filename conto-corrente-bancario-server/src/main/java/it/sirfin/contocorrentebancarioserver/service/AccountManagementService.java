package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;

public interface AccountManagementService {

    ListaContiCorrenteDto aggiungiCc(ContoCorrente cc);
}
