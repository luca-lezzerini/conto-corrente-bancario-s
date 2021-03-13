package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.service.MovimentiManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MovimentiManagementController {

    @Autowired
    MovimentiManagementService movimentiManagementService;

    @RequestMapping("ricerca-cliente-like")
    @ResponseBody
    public ListaClientiDto cercaClienteLike(@RequestBody RicercaClienteDto dto) {
        return movimentiManagementService.cercaClienteLike(dto.getRicercaPerCognome());
    }

    @RequestMapping("ricerca-conti-associati-cliente")
    @ResponseBody
    public TuttiContiDto ricercaContiAssociatiCliente(@RequestBody ClienteDto dto) {
        return movimentiManagementService.ricercaContiAssociatiCliente(dto.getCliente());
    }
    
    @RequestMapping("ricerca-cliente-saldo-cc")
    @ResponseBody
    public ListaClientiDto cercaClienteSaldo(@RequestBody RicercaClienteDto dto) {
        return movimentiManagementService.cercaClienteSaldo(dto.getRicercaPerCognome());
    }
    
}
