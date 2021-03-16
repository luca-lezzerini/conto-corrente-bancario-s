package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCcDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentiAssCpDto;
import it.sirfin.contocorrentebancarioserver.dto.RitMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.repository.MovimentiContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.MovimentiContoDepositoRepository;
import java.util.Set;
import it.sirfin.contocorrentebancarioserver.repository.MovimentiContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.MovimentiManagementService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentiManagementServiceImpl implements MovimentiManagementService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContoCorrenteRepository contoCorrenteRepository;

    @Autowired
    ContoDepositoRepository contoDepositoRepository;

    @Autowired
    ContoPrestitoRepository contoPrestitoRepsitory;

    @Autowired
    MovimentiContoCorrenteRepository movimentiContoCorrenteRepository;

    @Autowired
    MovimentiContoPrestitoRepository movimentiContoPrestitoRepository;

    @Autowired
    MovimentiContoDepositoRepository movimentiContoDepositoRepository;

    @Override
    public void demo3() {
        //Creazione dati di test
        movimentiContoCorrenteRepository.deleteAllInBatch();

        //Comment metodi inserimento
        //creazione archivio clienti
        MovimentiContoCorrente c1 = new MovimentiContoCorrente(LocalDate.of(2001, 9, 11), "Versamento", 1500.50);
        c1 = movimentiContoCorrenteRepository.save(c1);
        //creazione archivio clienti
        MovimentiContoCorrente c2 = new MovimentiContoCorrente(LocalDate.of(2006, 7, 26), "Prelievo", 500);
        c2 = movimentiContoCorrenteRepository.save(c2);
        //creazione archivio clienti
        MovimentiContoCorrente c3 = new MovimentiContoCorrente(LocalDate.of(2000, 1, 12), "Bonifico", 47.45);
        c3 = movimentiContoCorrenteRepository.save(c3);
        //creazione archivio conti corrente
        ContoCorrente cC1 = new ContoCorrente("Conto4");
        ContoCorrente cC2 = new ContoCorrente("Conto5");
        ContoCorrente cC3 = new ContoCorrente("Conto6");
        //salvo su db
        cC1 = contoCorrenteRepository.save(cC1);
        cC2 = contoCorrenteRepository.save(cC2);
        cC3 = contoCorrenteRepository.save(cC3);

    }

    @Override
    public ListaClientiDto cercaClienteLike(String c) {
        ListaClientiDto lista = new ListaClientiDto(
                clienteRepository.findByCognomeContaining(c));
        return lista;
    }

    @Override
    public ListaClientiDto cercaClienteSaldo(String c) {
        ListaClientiDto lista2 = new ListaClientiDto(
                clienteRepository.findByCognomeContaining(c));
        return lista2;
    }

    @Override
    public TuttiContiDto ricercaContiAssociatiCliente(Cliente c) {
        TuttiContiDto conti = new TuttiContiDto();
        //Il Cliente spedito da client non contiene i set di associazione ai conti.
        //Per cui recuperiamo da DB il cliente che ha lo stesso id di quello mandato 
        //dal client.
        //A questo punto il cliente recuperato da DB contiene tutte le associazioni ai
        //vari conti e possiamo procedere a preparare i dati e rimandarli al client.
        Cliente cliente = clienteRepository.findById(c.getId()).get();
        conti.setContiDeposito(cliente.getContiDeposito());
        System.out.println("");
        return conti;
    }

    /*
    @Override
    public MovimentaContoCorrenteDto movimentacC(MovimentaContoCorrenteDto i) {
        MovimentaContoCorrenteDto listacCMov = new MovimentaContoCorrenteDto();
        contoCorrenteRepository.findByCodiceContoContains(i);
        return listacCMov;
    }
     */
    @Override
    public MovimentiAssCpDto cercaContoCp(String c) {
        MovimentiAssCpDto conto = new MovimentiAssCpDto();
        conto.setContoPrestito(contoPrestitoRepsitory.findByCodice(c));
        conto.setMovimentiContoPrestito(movimentiContoPrestitoRepository.findByContoPrestitoId(
                conto.getContoPrestito().getId()));
        return conto;
    }

    @Override
    public ListaMovimentiCpDto salvaMovimento(MovimentiContoPrestito mcp, ContoPrestito cp) {
        associaMovimentoCp(mcp, cp);
        ListaMovimentiCpDto lista = new ListaMovimentiCpDto(
                movimentiContoPrestitoRepository.findByContoPrestitoId(cp.getId()));
        System.out.println("quantità movimenti associati" + lista.getListaMovimentiCp().size());
        return lista;
    }

    private void associaMovimentoCp(MovimentiContoPrestito mcp, ContoPrestito cp) {
        mcp = movimentiContoPrestitoRepository.save(mcp);
        mcp.setContoPrestito(cp);
        Set<MovimentiContoPrestito> movimenti = cp.getMovimentiContoPrestito();
        movimenti.add(mcp);
        contoPrestitoRepsitory.save(cp);
        movimentiContoPrestitoRepository.save(mcp);
    }

    @Override
    public ListaMovimentiCdDto salvaMovimentoCd(ContoDeposito cd, MovimentiContoDeposito mcd) {
        associaMovimentoCd(mcd, cd);
        ListaMovimentiCdDto lista = new ListaMovimentiCdDto(
                movimentiContoDepositoRepository.findByContoDepositoId(cd.getId()));
        return lista;
    }

    private void associaMovimentoCd(MovimentiContoDeposito mcd, ContoDeposito cd) {
        mcd = movimentiContoDepositoRepository.save(mcd);
        mcd.setContoDeposito(cd);
        Set<MovimentiContoDeposito> movimentiCd = cd.getMovimentiContoDeposito();
        movimentiCd.add(mcd);
        contoDepositoRepository.save(cd);
        movimentiContoDepositoRepository.save(mcd);
    }

    @Override
    public ListaMovimentiCdDto estrattoContoCd(ContoDeposito cd) {
        ListaMovimentiCdDto movimenti = new ListaMovimentiCdDto(
                movimentiContoDepositoRepository.findByContoDepositoId(cd.getId()));
        return movimenti;
    }

    @Override
    public ListaClientiDto cercaClienteECCC(String c) {
        ListaClientiDto lista = new ListaClientiDto(
                clienteRepository.findByCognomeContaining(c));
        return lista;
    }

    @Override
    public ListaMovimentiCcDto salvaMovimentoCc(ContoCorrente cc, MovimentiContoCorrente mcc) {
        associaMovimentiCC(mcc, cc);
        ListaMovimentiCcDto lista = new ListaMovimentiCcDto(movimentiContoCorrenteRepository.findByContoCorrenteId(cc.getId()));
        return lista;
    }

    private void associaMovimentiCC(MovimentiContoCorrente mcc, ContoCorrente cc) {
        mcc.setContoCorrente(cc);
        mcc = movimentiContoCorrenteRepository.save(mcc);
        Set<MovimentiContoCorrente> movimentiCc = cc.getMovimentiContoCorrente();
        movimentiCc.add(mcc);
        contoCorrenteRepository.save(cc);
        movimentiContoCorrenteRepository.save(mcc);
    }

    @Override
    public RitMovimentiCdDto ritMovimentiCd(String c) {
        RitMovimentiCdDto conto = new RitMovimentiCdDto();
        conto.setContoDeposito(contoDepositoRepository.findByCodice(c));
        conto.setMovimentiContoDeposito(movimentiContoDepositoRepository.findByContoDepositoId(
                conto.getContoDeposito().getId()));
        return conto;
    }

//    @Override
//    public ListaContiCorrenteDto selezionaECCC(Cliente c) {
//
//    }
    
    
}
