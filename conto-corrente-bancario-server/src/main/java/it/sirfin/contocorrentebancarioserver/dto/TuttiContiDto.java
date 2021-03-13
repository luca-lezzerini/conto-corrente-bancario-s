package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import java.util.List;
import java.util.Set;

public class TuttiContiDto {

    private Set<ContoDeposito> contiDeposito;
    private Set<ContoCorrente> contiCorrenti;
    private Set<ContoPrestito> contiPrestito;

    public TuttiContiDto(Set<ContoDeposito> contiDeposito, Set<ContoCorrente> contiCorrenti, Set<ContoPrestito> contiPrestito) {
        this.contiDeposito = contiDeposito;
        this.contiCorrenti = contiCorrenti;
        this.contiPrestito = contiPrestito;
    }

    public TuttiContiDto() {
    }

    public Set<ContoDeposito> getContiDeposito() {
        return contiDeposito;
    }

    public void setContiDeposito(Set<ContoDeposito> contiDeposito) {
        this.contiDeposito = contiDeposito;
    }

    public Set<ContoCorrente> getContiCorrenti() {
        return contiCorrenti;
    }

    public void setContiCorrenti(Set<ContoCorrente> contiCorrenti) {
        this.contiCorrenti = contiCorrenti;
    }

    public Set<ContoPrestito> getContiPrestito() {
        return contiPrestito;
    }

    public void setContiPrestito(Set<ContoPrestito> contiPrestito) {
        this.contiPrestito = contiPrestito;
    }

    
}
