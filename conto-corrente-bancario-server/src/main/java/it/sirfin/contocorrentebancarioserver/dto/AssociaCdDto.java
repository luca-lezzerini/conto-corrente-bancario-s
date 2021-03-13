package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;

public class AssociaCdDto {

    private ContoDeposito contoDeposito;
    private Cliente cliente;

    public AssociaCdDto() {
    }

    public AssociaCdDto(ContoDeposito contoDeposito, Cliente cliente) {
        this.contoDeposito = contoDeposito;
        this.cliente = cliente;
    }

    public ContoDeposito getContoDeposito() {
        return contoDeposito;
    }

    public void setContoDeposito(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
