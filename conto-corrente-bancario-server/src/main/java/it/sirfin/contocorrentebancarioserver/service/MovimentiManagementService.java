package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentiAssCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentoCpDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;

public interface MovimentiManagementService {

    ListaClientiDto cercaClienteLike(String c);

    ListaClientiDto cercaClienteSaldo(String c);

    TuttiContiDto ricercaContiAssociatiCliente(Cliente c);

    void demo3();
    //MovimentaContoCorrenteDto movimentacC(MovimentaContoCorrenteDto i);

    MovimentiAssCpDto cercaContoCp(String c);

    ListaMovimentiCpDto salvaMovimento(MovimentiContoPrestito mcp, ContoPrestito cp);

    ListaMovimentiCdDto salvaMovimentoCd(ContoDeposito cd, MovimentiContoDeposito mcd);

    ListaClientiDto cercaClienteECCC(String c);

    ListaMovimentiCdDto estrattoContoCd(ContoDeposito cd);
}
