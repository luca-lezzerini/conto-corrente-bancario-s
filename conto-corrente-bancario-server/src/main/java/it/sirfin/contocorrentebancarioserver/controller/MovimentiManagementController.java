package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentoCpDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
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

    @RequestMapping("/demo3")
    public void demo3() {
        movimentiManagementService.demo3();
    }
    @Autowired
    MovimentiManagementService movimentiManagementService;

    @RequestMapping("/ricerca-cliente-like")
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

    @RequestMapping("cerca-cp")
    @ResponseBody
    public ContoPrestitoDto cercaContoCp(@RequestBody RicercaContoCorrenteDto dto) {
        return movimentiManagementService.cercaContoCp(dto.getCodiceEsatto());
    }

    @RequestMapping("salva-movimento-cp")
    @ResponseBody
    public ListaMovimentiCpDto salvaMovimento(@RequestBody MovimentoCpDto dto1) {
        return movimentiManagementService.salvaMovimento(dto1);
    }
}

