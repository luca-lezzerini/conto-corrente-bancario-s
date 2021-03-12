/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.dto;

/**
 *
 * @author Palo
 */
public class RicercaClienteDto {

    private String ricercaPerCognome;

    public RicercaClienteDto() {
    }

    public RicercaClienteDto(String ricercaPerCognome) {
        this.ricercaPerCognome = ricercaPerCognome;
    }

    public String getRicercaPerCognome() {
        return ricercaPerCognome;
    }

    public void setRicercaPerCognome(String ricercaPerCognome) {
        this.ricercaPerCognome = ricercaPerCognome;
    }

    @Override
    public String toString() {
        return "RicercaClienteDto{" + "ricercaPerCognome=" + ricercaPerCognome + '}';
    }

}
