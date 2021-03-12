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
    public ListaClientiDto aggiungi(@RequestBody ClienteDto dto){
        System.out.println("siamo su aggiungi");
        ListaClientiDto risp = contoCorrenteService.aggiungi(dto.getCliente());
        System.out.println(risp);
        return risp;
    }
    
    @RequestMapping("/aggiorna")
    @ResponseBody
    public ListaClientiDto aggiorna(@RequestBody ClienteDto dto){
        return contoCorrenteService.aggiorna();
    }
}
