package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.service.SystemAdminService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminServiceImpl implements SystemAdminService{

    @Autowired
    ClienteRepository clienteRepository;
    
    @Override
    public void queryAnnotation() {
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("Mario", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Giorgio", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Franco", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Vasco", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Italo", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Maria", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Antonella", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Claudia", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Marta", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Genoveffa", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Barbara", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Luigi", "Rossi", "ABD", "via", "tel", LocalDate.now()));
        lista.add(new Cliente("Ersilio", "Persichetti", "ABD", "via", "tel", LocalDate.now()));
        
        clienteRepository.saveAll(lista);
        
        // cerco tutti i clienti di cognome Persichetti
        Collection<Cliente> colCli = clienteRepository.trovaClientePerCognome("Persichetti");
        System.out.println(colCli);
        List<Cliente> lisCli = clienteRepository.trovaClientePerCognomeList("Persichetti");
        System.out.println(lisCli);
//        Stream<Cliente> strCli = clienteRepository.trovaClientePerCognomeStream("Persichetti");
//        System.out.println(strCli);

        // vado a pagina 6, con 10 elementi a pagina
        Sort ss = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pag = PageRequest.of(0, 10, ss);
        lisCli = clienteRepository.cercaClientiPaginato(pag);
        System.out.println("Elementi " + lisCli.size());
        System.out.println(lisCli);
    }

}
