package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;


public class AssociaCpDto {
    private Cliente cliente;
    private ContoPrestito contoPrestito;

    public AssociaCpDto() {
    }

    public AssociaCpDto(Cliente cliente, ContoPrestito contoPrestito) {
        this.cliente = cliente;
        this.contoPrestito = contoPrestito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContoPrestito getContoPrestito() {
        return contoPrestito;
    }

    public void setContoPrestito(ContoPrestito contoPrestito) {
        this.contoPrestito = contoPrestito;
    }
    
}
