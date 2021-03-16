package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.MessaggioPerUtenteDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.sirfin.contocorrentebancarioserver.service.ContoCorrenteService;
import java.util.Set;

@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContoCorrenteRepository contoCorrenteRepository;

    @Autowired
    ContoDepositoRepository contoDepositoRepository;

    @Autowired
    ContoPrestitoRepository contoPrestitoRepsitory;

    @Override
    public void demo() {

        contoCorrenteRepository.deleteAllInBatch();
        contoDepositoRepository.deleteAllInBatch();
        contoPrestitoRepsitory.deleteAllInBatch();
        clienteRepository.deleteAllInBatch();

    }

    @Override
    public ListaClientiDto aggiungi(Cliente c) {
        clienteRepository.save(c);
        return aggiorna();
    }

    @Override
    public ListaClientiDto aggiorna() {
        List<Cliente> clienti = clienteRepository.findAll();
        return new ListaClientiDto(clienti);
    }

    @Override
    public ListaClientiDto cancella(Cliente c) {
        clienteRepository.delete(c);
        return aggiorna();
    }

    @Override
    public ClienteDto modificaCliente(Cliente c) {
        ClienteDto dtoRes = new ClienteDto(clienteRepository
                .findById(c.getId()).get());
        System.out.println("=====1");
        System.out.println("Cliente " + dtoRes.getCliente());
        System.out.println("=====2");
        return dtoRes;
    }

    @Override
    public ListaClientiDto confermaModificaCliente(Cliente c) {
        Cliente c2 = clienteRepository.findById(c.getId()).get();
        System.out.println("C2 " + c2);
        c  = clienteRepository.save(c);
        Set<ContoCorrente> cc = c.getContiCorrenti();
        System.out.println("Cliente = " + c);
        return new ListaClientiDto(
                clienteRepository.findAll());
    }

    private void associaClienteCC(Cliente c, ContoCorrente cc) {
        cc.setCliente(c);
        contoCorrenteRepository.save(cc);
        Set<ContoCorrente> conti = c.getContiCorrenti();
        conti.add(cc);
        clienteRepository.save(c);
    }

}
