package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.MovimentiManagementService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentiManagementServiceImpl implements MovimentiManagementService{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContoCorrenteRepository contoCorrenteRepository;

    @Autowired
    ContoDepositoRepository contoDepositoRepository;

    @Autowired
    ContoPrestitoRepository contoPrestitoRepsitory;

    @Override
    public ListaClientiDto cercaClienteLike(String c) {
        ListaClientiDto lista = new ListaClientiDto(
                clienteRepository.findByCognomeContaining(c));
        List <Cliente> listaClienti = clienteRepository.findByCognomeContaining(c);
        return lista;
    }

    @Override
    public TuttiContiDto ricercaContiAssociatiCliente(Cliente c) {
        TuttiContiDto conti = new TuttiContiDto();
        System.out.println("siamo nel service di ricercaContiAssociatiCliente");
        System.out.println("cliente: " + c.getNome());
        Set<ContoDeposito> contiDeposito = c.getContiDeposito();
        System.out.println("numero conti deposito trovati associati a: " + c.getNome());
        return conti;
    }
    
    


    
}
