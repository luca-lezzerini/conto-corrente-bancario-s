package it.sirfin.contocorrentebancarioserver.service;

import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.MessaggioPerUtenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentaContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentoCpDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import java.util.List;

public interface MovimentiManagementService {

    ListaClientiDto cercaClienteLike(String c);

    ListaClientiDto cercaClienteSaldo(String c);

    TuttiContiDto ricercaContiAssociatiCliente(Cliente c);

    void demo3();
    //MovimentaContoCorrenteDto movimentacC(MovimentaContoCorrenteDto i);

    ContoPrestitoDto cercaContoCp(String c);

    ListaMovimentiCpDto salvaMovimento(MovimentoCpDto dto);

    MovimentiContoDeposito saldo(ContoDeposito cd, MovimentiContoDeposito mcd);
}
