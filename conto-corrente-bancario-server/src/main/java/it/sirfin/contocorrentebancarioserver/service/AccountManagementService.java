package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiPrestitoDto;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;

public interface AccountManagementService {

    ListaContiCorrenteDto aggiungiCc(ContoCorrente cc);

    ListaContiCorrenteDto eliminaCc(ContoCorrente cc);

    ContoCorrenteDto modificaCc(ContoCorrente cc);

    ListaContiCorrenteDto confermaCc(ContoCorrente cc);

    ListaContiDepositoDto aggiungicontodeposito(ContoDeposito cd);

    ListaContiDepositoDto eliminaCd(ContoDeposito cd);

    ListaContiDepositoDto aggiornaContiDeposito();

    ListaContiPrestitoDto aggiungiContoPrestito(ContoPrestito cp);

    ListaContiPrestitoDto aggiornaContiPrestito();

    ListaClientiDto ricercaC(String c);

    ListaContiCorrenteDto ricercaCc(String n);
}
