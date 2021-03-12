package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AccountManagementController {

    @Autowired
    AccountManagementService accountManagementService;

    @RequestMapping("/aggiungi-cc")
    @ResponseBody
    public ListaContiCorrenteDto aggiungiCc(@RequestBody ContoCorrenteDto dto) {
        //return accountManagementService.aggiungiCc(dto.getContoCorrente());
        throw new UnsupportedOperationException();
    }
}
