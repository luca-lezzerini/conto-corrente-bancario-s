package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.service.ContoCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ContoCorrenteBancarioController {

    @Autowired
    ContoCorrenteService contoCorrenteService;

    @RequestMapping("/aggiungi")
    @ResponseBody
    public ListaClientiDto aggiungi(@RequestBody ClienteDto dto) {
        return contoCorrenteService.aggiungi(dto.getCliente());
    }

    @RequestMapping("/aggiorna-cliente")
    @ResponseBody
    public ListaClientiDto aggiorna() {
        System.out.println("siamo in aggiorna");
        return contoCorrenteService.aggiorna();
    }

    @RequestMapping("/cancella")
    @ResponseBody
    public ListaClientiDto cancella(@RequestBody ClienteDto dto) {
        System.out.println("siamo su cancella");
        ListaClientiDto risp = contoCorrenteService.cancella(dto.getCliente());
        return risp;
    }

    @RequestMapping("/modifica-cliente")
    @ResponseBody
    public ClienteDto modificaCliente(@RequestBody ClienteDto dto) {
        return contoCorrenteService.ModificaCliente(dto.getCliente());
    }

    @RequestMapping("/conferma-modifica-cliente")
    @ResponseBody
    public ListaClientiDto confermaModificaCliente(@RequestBody ClienteDto dto) {
        return contoCorrenteService.confermaModificaCliente(dto.getCliente());
    }

    @RequestMapping("/demo")
    public void demo() {
        contoCorrenteService.demo();
    }
}
