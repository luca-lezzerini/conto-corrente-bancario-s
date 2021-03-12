package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.sirfin.contocorrentebancarioserver.service.ContoCorrenteService;

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

        clienteRepository.deleteAllInBatch();
        contoCorrenteRepository.deleteAllInBatch();
        contoDepositoRepository.deleteAllInBatch();
        contoPrestitoRepsitory.deleteAllInBatch();
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
    public ClienteDto ModificaCliente(Cliente c) {
        ClienteDto dtoRes = new ClienteDto(clienteRepository
                .findById(c.getId()).get());
        return dtoRes;
    }

    @Override
    public ListaClientiDto confermaModificaCliente(Cliente c) {
        clienteRepository.save(c);
        return new ListaClientiDto(
                clienteRepository.findAll());
    }

}
