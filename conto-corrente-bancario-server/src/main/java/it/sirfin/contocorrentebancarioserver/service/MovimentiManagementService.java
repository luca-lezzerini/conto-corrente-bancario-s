package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCcDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentiAssCpDto;
import it.sirfin.contocorrentebancarioserver.dto.RitMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.SaldoCdDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;

public interface MovimentiManagementService {

    ListaClientiDto cercaClienteLike(String c);

    ListaClientiDto cercaClienteSaldo(String c);

    TuttiContiDto ricercaContiAssociatiCliente(Cliente c);

    void demo3();

    ListaMovimentiCcDto salvaMovimentoCc(ContoCorrente cc, MovimentiContoCorrente mcc);

    MovimentiAssCpDto cercaContoCp(String c);

    ListaMovimentiCpDto salvaMovimento(MovimentiContoPrestito mcp, ContoPrestito cp);

    ListaMovimentiCdDto salvaMovimentoCd(ContoDeposito cd, MovimentiContoDeposito mcd);

    ListaClientiDto cercaClienteECCC(String c);

    ListaMovimentiCdDto estrattoContoCd(ContoDeposito cd);

    RitMovimentiCdDto ritMovimentiCd(String c);

    TuttiContiDto selezionaECCC(Cliente c);
    
    SaldoCdDto saldoCd(ContoDeposito cd, MovimentiContoDeposito mcd);
    
    ListaMovimentiCcDto estrattoContoCC(ContoCorrente cc);
}
