package it.sirfin.contocorrentebancarioserver.serviceImpl;

import it.sirfin.contocorrentebancarioserver.repository.ClienteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoCorrenteRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoDepositoRepository;
import it.sirfin.contocorrentebancarioserver.repository.ContoPrestitoRepository;
import it.sirfin.contocorrentebancarioserver.service.AccountManagementService;
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
    ContoPrestitoRepository contoPrestitoRepsitory;
}
