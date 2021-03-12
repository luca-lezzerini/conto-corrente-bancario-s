
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;

public class ContoDepositoDto {
    
    ContoDeposito contoDeposito;

    public ContoDepositoDto() {
    }

    public ContoDepositoDto(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    public ContoDeposito getContoDeposito() {
        return contoDeposito;
    }

    public void setContoDeposito(ContoDeposito contoDeposito) {
        this.contoDeposito = contoDeposito;
    }

    @Override
    public String toString() {
        return "ContoDepositoDto{" + "contoDeposito=" + contoDeposito + '}';
    }
    
    
    
}
