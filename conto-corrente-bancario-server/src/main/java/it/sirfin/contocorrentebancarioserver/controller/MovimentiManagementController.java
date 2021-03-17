package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.dto.ClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.ContoDepositoDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaClientiDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCcDto;
import it.sirfin.contocorrentebancarioserver.dto.ListaMovimentiCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentaCdDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentaContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentiAssCpDto;
import it.sirfin.contocorrentebancarioserver.dto.MovimentoCpDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaClienteDto;
import it.sirfin.contocorrentebancarioserver.dto.RicercaContoCorrenteDto;
import it.sirfin.contocorrentebancarioserver.dto.RitMovimentiCdDto;
import it.sirfin.contocorrentebancarioserver.dto.SaldoCdDto;
import it.sirfin.contocorrentebancarioserver.dto.TuttiContiDto;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
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

    @RequestMapping("ricerca-movimenti-cd")
    @ResponseBody
    public ListaMovimentiCdDto estrattoContoCd(@RequestBody ContoDepositoDto dto) {
        return movimentiManagementService.estrattoContoCd(dto.getContoDeposito());
    }

    @RequestMapping("ricerca-cliente-saldo-cc")
    @ResponseBody
    public ListaClientiDto cercaClienteSaldo(@RequestBody RicercaClienteDto dto) {
        return movimentiManagementService.cercaClienteSaldo(dto.getRicercaPerCognome());
    }

    @RequestMapping("cerca-cp")
    @ResponseBody
    public MovimentiAssCpDto cercaContoCp(@RequestBody RicercaContoCorrenteDto dto) {
        return movimentiManagementService.cercaContoCp(dto.getCodiceEsatto());
    }

    @RequestMapping("salva-movimento-cp")
    @ResponseBody
    public ListaMovimentiCpDto salvaMovimento(@RequestBody MovimentoCpDto dto1) {
        return movimentiManagementService.salvaMovimento(dto1.getMovimentoCp(), dto1.getContoPrestito());
    }

    @RequestMapping("salva-movimento-cd")
    @ResponseBody
    public ListaMovimentiCdDto salvaMovimento(@RequestBody MovimentaCdDto dto) {
        ContoDeposito cd = dto.getContoDeposito();
        MovimentiContoDeposito mc = dto.getMovimentoCd();
        return movimentiManagementService.salvaMovimentoCd(cd, mc);
    }

    @RequestMapping("salva-movimento-cc")
    @ResponseBody
    public ListaMovimentiCcDto salvaMovimento(@RequestBody MovimentaContoCorrenteDto dto) {
        return movimentiManagementService.salvaMovimentoCc(dto.getContoCorrente(), dto.getMovimentoCc());
    }

    @RequestMapping("ricerca-cliente-e-c-cc")
    @ResponseBody
    public ListaClientiDto ricercaClienteECCC(@RequestBody RicercaClienteDto dto) {
        return movimentiManagementService.cercaClienteECCC(dto.getRicercaPerCognome());
    }

    @RequestMapping("cd-ricerca")
    @ResponseBody
    public RitMovimentiCdDto ricercaCd(@RequestBody RicercaContoCorrenteDto dto) {
        return movimentiManagementService.ritMovimentiCd(dto.getCodiceEsatto());
    }

//    @RequestMapping("seleziona-e-c-cc")
//    @ResponseBody
//    public TuttiContiDto selezionaECCC(@RequestBody ClienteDto dto) {
//        return movimentiManagementService.selezionaECCC(dto.getCliente());
//    }
    @RequestMapping("saldo-cd")
    @ResponseBody
    public SaldoCdDto saldoCd(@RequestBody MovimentaCdDto dto) {
        return movimentiManagementService.saldoCd(
                dto.getContoDeposito(), dto.getMovimentoCd());
    }

}
