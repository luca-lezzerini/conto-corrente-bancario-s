package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiPrestitoDto;
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
        return accountManagementService.aggiungiCc(dto.getContoCorrente());
    }

    @RequestMapping("/elimina-cc")
    @ResponseBody
    public ListaContiCorrenteDto eliminaCc(@RequestBody ContoCorrenteDto dto) {
        return accountManagementService.eliminaCc(dto.getContoCorrente());
    }

    @RequestMapping("modifica-cc")
    @ResponseBody
    public ContoCorrenteDto modificaCc(@RequestBody ContoCorrenteDto dto) {
        return accountManagementService.modificaCc(dto.getContoCorrente());
    }

    @RequestMapping("conferma-cc")
    @ResponseBody
    public ListaContiCorrenteDto confermaCc(@RequestBody ContoCorrenteDto dto) {
        return accountManagementService.confermaCc(dto.getContoCorrente());
    }
    
     @RequestMapping("/aggiungi-contodeposito")
    @ResponseBody
    public ListaContiDepositoDto aggiungiContodeposito(@RequestBody ContoDepositoDto dto) {
        return accountManagementService.aggiungicontodeposito(dto.getContoDeposito());
    }
    
    @RequestMapping("/elimina-contodeposito")
    @ResponseBody
    public ListaContiDepositoDto eliminaContodeposito(@RequestBody ContoDepositoDto dto) {
        return accountManagementService.eliminaCd(dto.getContoDeposito());
    }
    
    @RequestMapping("/aggiungi-cp")
    @ResponseBody
    public ListaContiPrestitoDto aggiungiContoPrestito (@RequestBody ContoPrestitoDto dto) {
        return accountManagementService.aggiungiContoPrestito(dto.getContoPrestito());
    }
}
