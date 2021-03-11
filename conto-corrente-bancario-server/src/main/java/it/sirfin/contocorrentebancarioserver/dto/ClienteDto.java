package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;

public class ClienteDto {
    
    private Cliente cliente;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ClienteDto{" + "cliente=" + cliente + '}';
    }
    
    
}
