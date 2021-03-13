package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.AssociaCdDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaContiPrestitoDto;
import it.sirfin.contocorrentebancarioserver.dto.MessaggioPerUtenteDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaContoCorrenteDto;
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

    @RequestMapping("/aggiorna-cc")
    @ResponseBody
    public ListaContiCorrenteDto aggiornaContiCorrenteDto() {
        return accountManagementService.aggiornaContiCorrente();
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

    @RequestMapping("/aggiorna-cd")
    @ResponseBody
    public ListaContiDepositoDto aggiornaContiDeposito() {
        return accountManagementService.aggiornaContiDeposito();
    }

    @RequestMapping("/aggiungi-cp")
    @ResponseBody
    public ListaContiPrestitoDto aggiungiContoPrestito(@RequestBody ContoPrestitoDto dto) {
        return accountManagementService.aggiungiContoPrestito(dto.getContoPrestito());
    }

    @RequestMapping("/aggiorna-cp")
    @ResponseBody
    public ListaContiPrestitoDto aggiornaContiPrestito() {
        return accountManagementService.aggiornaContiPrestito();
    }

    @RequestMapping("ricerca-c")
    @ResponseBody
    public ListaClientiDto ricercaCliente(@RequestBody RicercaClienteDto dto) {
        return accountManagementService.ricercaC(dto.getRicercaPerCognome());
    }

    @RequestMapping("ricerca-cc")
    @ResponseBody
    public ContoCorrenteDto ricercaContoCorrente(@RequestBody RicercaContoCorrenteDto dto) {
        return accountManagementService.ricercaCc(dto.getCodiceEsatto());
    }

    @RequestMapping("ricerca-cd")
    @ResponseBody
    public ContoDepositoDto ricercaContoDepositoDto(@RequestBody RicercaContoCorrenteDto dto) {
        return accountManagementService.ricercaCd(dto.getCodiceEsatto());
    }

    @RequestMapping("/elimina-cp")
    @ResponseBody
    public ListaContiPrestitoDto eliminaCp(@RequestBody ContoPrestitoDto dto) {
        return accountManagementService.eliminaCp(dto.getContoPrestito());
    }

    @RequestMapping("modifica-cp")
    @ResponseBody
    public ContoPrestitoDto modificaCp(@RequestBody ContoPrestitoDto dto) {
        return accountManagementService.modificaCp(dto.getContoPrestito());
    }

    @RequestMapping("associa-cd")
    @ResponseBody
    public MessaggioPerUtenteDto associa(@RequestBody AssociaCdDto assDto) {
        return accountManagementService.associaCd(
                assDto.getCliente(), assDto.getContoDeposito());
    }
}
