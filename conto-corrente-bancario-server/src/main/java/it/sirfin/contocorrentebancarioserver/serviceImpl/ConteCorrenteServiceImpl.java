package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.ContoCorrenteSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteCorrenteServiceImpl implements ContoCorrenteSevice {
     @Autowired
ClientiRepository clientiRepository

     @Autowired
ContoCorrenteRepository contoCorrenteRepository;

    @Autowired
ContoDepositoRepository contoDepositoRepository;

    @Autowired
ContoPrestitoRepository contoPrestitoRepsitory;



 @Override
    public void conto bancario(){

clientiRepository.deleteAllInBatch();
contoCorrenteRepository.deleteAllInBatch();
contoDepositoRepository.deleteAllInBatch();
contoPrestitoRepsitory.deleteAllInBatch();

Cliente c1= new Cliente("Marco","Bonaccorso","","","");
ContoCorrente cC1=new ContoCorrente("");
ContoPrestito cP1=new ContoPrestito("");
ContoDeposito cD1= new ContoDeposito("");
}


}
