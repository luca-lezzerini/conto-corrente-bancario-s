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
public class SaldoCdDto {

    private double saldo;

    public SaldoCdDto() {
    }

    public SaldoCdDto(double salodo) {
        this.saldo = salodo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "SaldoCdDto{" + "salodo=" + saldo + '}';
    }

}
