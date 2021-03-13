package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.MovimentiManagementService;
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
        return lista;
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
    
    


    
}
