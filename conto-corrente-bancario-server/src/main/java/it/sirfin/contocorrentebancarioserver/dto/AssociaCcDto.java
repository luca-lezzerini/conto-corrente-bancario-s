/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;

/**
 *
 * @author Palo
 */
public class AssociaCcDto {

    private Cliente cliente;
    private ContoCorrente contoCorrente;

    public AssociaCcDto() {
    }

    public AssociaCcDto(Cliente cliente, ContoCorrente contoCorrente) {
        this.cliente = cliente;
        this.contoCorrente = contoCorrente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContoCorrente getContoCorrente() {
        return contoCorrente;
    }

    public void setContoCorrente(ContoCorrente contoCorrente) {
        this.contoCorrente = contoCorrente;
    }

    @Override
    public String toString() {
        return "AssociaCcDto{" + "cliente=" + cliente + ", contoCorrente=" + contoCorrente + '}';
    }

}
