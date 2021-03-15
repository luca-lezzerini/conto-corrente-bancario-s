package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.AssociaCcDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.MessaggioPerUtenteDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountManagementService {

    ListaContiCorrenteDto inserisciMovimento(ContoCorrente contoCorrente);
    
    ListaContiCorrenteDto aggiungiCc(ContoCorrente cc);

    ListaContiCorrenteDto eliminaCc(ContoCorrente cc);

    public void associaMCcC(MovimentiContoCorrente mcc, ContoCorrente cc);

    ContoCorrenteDto modificaCc(ContoCorrente cc);

    ListaContiCorrenteDto confermaCc(ContoCorrente cc);

    ListaContiCorrenteDto aggiornaContiCorrente();

    MessaggioPerUtenteDto associaCcaC(Cliente c, ContoCorrente cc);

    ListaContiDepositoDto aggiungicontodeposito(ContoDeposito cd);

    ListaContiDepositoDto eliminaCd(ContoDeposito cd);

    ListaContiDepositoDto aggiornaContiDeposito();

    ListaContiPrestitoDto aggiungiContoPrestito(ContoPrestito cp);

    ListaContiPrestitoDto aggiornaContiPrestito();

    ListaContiPrestitoDto eliminaCp(ContoPrestito cp);

    ContoPrestitoDto modificaCp(ContoPrestito cp);

    ListaClientiDto ricercaC(String c);

    ContoCorrenteDto ricercaCc(String n);

    ContoDepositoDto ricercaCd(String n);

    MessaggioPerUtenteDto associaCd(Cliente c, ContoDeposito cd);

    ListaContiPrestitoDto confermaCp(ContoPrestito c);

    ContoDepositoDto selezionaCd(ContoDeposito cd);

    ListaContiDepositoDto ModificaCd(ContoDeposito cd);

    ContoPrestitoDto ricercaCp(String n);

    MessaggioPerUtenteDto associaCp(Cliente c, ContoPrestito cp);

    void demo();

}
