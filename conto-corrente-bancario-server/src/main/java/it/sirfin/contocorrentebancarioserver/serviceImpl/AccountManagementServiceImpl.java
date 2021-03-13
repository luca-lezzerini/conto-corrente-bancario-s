package it.sirfin.contocorrentebancarioserver.serviceImpl;

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
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.AccountManagementService;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManagementServiceImpl implements AccountManagementService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContoCorrenteRepository contoCorrenteRepository;

    @Autowired
    ContoDepositoRepository contoDepositoRepository;

    @Autowired
    ContoPrestitoRepository contoPrestitoRepository;

    public void demo() {

        clienteRepository.deleteAllInBatch();
        contoCorrenteRepository.deleteAllInBatch();
        contoDepositoRepository.deleteAllInBatch();
        contoPrestitoRepository.deleteAllInBatch();

        //creazione archivio clienti
        Cliente c1 = new Cliente("Mario", "Verdi", "MroVrd00A12H501U", "Via le Mani dal Naso 10", "3518864367", LocalDate.of(2000, 1, 12));
        c1 = clienteRepository.save(c1);
        Cliente c2 = new Cliente("Torri", "Gemelle", "TORGML01I11H501T", "Terreno zero", "3288864377", LocalDate.of(2001, 9, 11)); //idea di Francesco Lillo
        c2 = clienteRepository.save(c2);
        Cliente c3 = new Cliente("Kenshiro", "Kasumi", "KNHKSM87H14H501K", "Via Te Kuro Na Karia", "328473875", LocalDate.of(1983, 9, 13)); //idea di Francesco Lillo e Alessandro Urbani
        c3 = clienteRepository.save(c3);

        //creazione archivio conti corrente
        ContoCorrente cC1 = new ContoCorrente("Conto1");
        ContoCorrente cC2 = new ContoCorrente("Conto2");
        ContoCorrente cC3 = new ContoCorrente("Conto3");
        //salvo su db
        cC1 = contoCorrenteRepository.save(cC1);
        cC2 = contoCorrenteRepository.save(cC2);
        cC3 = contoCorrenteRepository.save(cC3);

        //creazione archivio Conto Prestito
        ContoPrestito cCP1 = new ContoPrestito("CodiceUno");
        ContoPrestito cCP2 = new ContoPrestito("CodiceDue");
        ContoPrestito cCP3 = new ContoPrestito("CodiceTre");
        //salvo su db
        cCP1 = contoPrestitoRepository.save(cCP1);
        cCP2 = contoPrestitoRepository.save(cCP2);
        cCP3 = contoPrestitoRepository.save(cCP3);

        //creazione archivio Conto Deposito
        ContoDeposito cCD1 = new ContoDeposito("codice1");
        ContoDeposito cCD2 = new ContoDeposito("codice2");
        ContoDeposito cCD3 = new ContoDeposito("codice3");

        //salvo su db
        cCD1 = contoDepositoRepository.save(cCD1);
        cCD2 = contoDepositoRepository.save(cCD2);
        cCD3 = contoDepositoRepository.save(cCD3);
    }

    @Override
    public ListaContiCorrenteDto aggiungiCc(ContoCorrente cc) {
        //salvo su db
        contoCorrenteRepository.save(cc);
        //implementare in seguito il metodo aggiorna
        List<ContoCorrente> lista = contoCorrenteRepository.findAll();
        return new ListaContiCorrenteDto(lista);
    }

    @Override
    public ListaContiCorrenteDto eliminaCc(ContoCorrente cc) {
        contoCorrenteRepository.delete(cc);
        List<ContoCorrente> lista = contoCorrenteRepository.findAll();
        return new ListaContiCorrenteDto(lista);
    }

    @Override
    public ContoCorrenteDto modificaCc(ContoCorrente cc) {
        return new ContoCorrenteDto(cc);
    }

    @Override
    public ListaContiCorrenteDto confermaCc(ContoCorrente cc) {
        contoCorrenteRepository.save(cc);
        List<ContoCorrente> lista = contoCorrenteRepository.findAll();
        return new ListaContiCorrenteDto(lista);
    }

    @Override
    public ListaContiDepositoDto aggiungicontodeposito(ContoDeposito cd) {
        contoDepositoRepository.save(cd);
        //implementare in seguito il metodo aggiorna
        return aggiornaContiDeposito();
    }

    @Override
    public ListaContiDepositoDto eliminaCd(ContoDeposito cd) {
        contoDepositoRepository.delete(cd);
        return aggiornaContiDeposito();
    }

    @Override
    public ListaContiDepositoDto aggiornaContiDeposito() {
        List<ContoDeposito> lista = contoDepositoRepository.findAll();
        return new ListaContiDepositoDto(lista);
    }

    @Override
    public ListaContiPrestitoDto aggiungiContoPrestito(ContoPrestito cp) {
        contoPrestitoRepository.save(cp);
        return aggiornaContiPrestito();
    }

    @Override
    public ListaContiPrestitoDto aggiornaContiPrestito() {
        List<ContoPrestito> lista = contoPrestitoRepository.findAll();
        return new ListaContiPrestitoDto(lista);
    }

    @Override
    public ListaClientiDto ricercaC(String c) {
        List<Cliente> lista = clienteRepository.findByCognome(c);
        return new ListaClientiDto(lista);
    }

    @Override
    public ListaContiCorrenteDto ricercaCc(String n) {
        List<ContoCorrente> lista = contoCorrenteRepository.findByNumeroConto(n);
        return new ListaContiCorrenteDto(lista);
    }

    @Override
    public ContoDepositoDto ricercaCd(String n) {
        ContoDeposito cd = contoDepositoRepository.findByCodice(n);
        return new ContoDepositoDto(cd);
    }    

    @Override
    public MessaggioPerUtenteDto associaCd(Cliente c, ContoDeposito cd) {
        cd.setCliente(c);
        contoDepositoRepository.save(cd);
        Set<ContoDeposito> conti = c.getContiDeposito();
        conti.add(cd);
        clienteRepository.save(c);
        return new MessaggioPerUtenteDto("conto associato con successo");
    }

    @Override
    public ListaContiPrestitoDto eliminaCp(ContoPrestito cp) {
        contoPrestitoRepository.delete(cp);
        return aggiornaContiPrestito();
    }

    @Override
    public ContoPrestitoDto modificaCp(ContoPrestito cp) {
        return new ContoPrestitoDto(cp);
    }
}
