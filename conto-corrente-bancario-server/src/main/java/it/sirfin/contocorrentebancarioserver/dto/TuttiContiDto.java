package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoCorrente;
import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import java.util.List;

public class TuttiContiDto {

    private List<ContoDeposito> contiDeposito;
    private List<ContoCorrente> contiCorrenti;
    private List<ContoPrestito> contiPrestito;

    public TuttiContiDto() {
    }

    public TuttiContiDto(List<ContoDeposito> contiDeposito, List<ContoCorrente> contiCorrenti, List<ContoPrestito> contiPrestito) {
        this.contiDeposito = contiDeposito;
        this.contiCorrenti = contiCorrenti;
        this.contiPrestito = contiPrestito;
    }

    public List<ContoDeposito> getContiDeposito() {
        return contiDeposito;
    }

    public void setContiDeposito(List<ContoDeposito> contiDeposito) {
        this.contiDeposito = contiDeposito;
    }

    public List<ContoCorrente> getContiCorrenti() {
        return contiCorrenti;
    }

    public void setContiCorrenti(List<ContoCorrente> contiCorrenti) {
        this.contiCorrenti = contiCorrenti;
    }

    public List<ContoPrestito> getContiPrestito() {
        return contiPrestito;
    }

    public void setContiPrestito(List<ContoPrestito> contiPrestito) {
        this.contiPrestito = contiPrestito;
    }

    
}
