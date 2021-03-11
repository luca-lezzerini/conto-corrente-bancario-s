package it.sirfin.contocorrentebancarioserver.serviceImpl;

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
public class ConteCorrenteServiceImpl implements ContoCorrenteService {

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
    
    
    

}
