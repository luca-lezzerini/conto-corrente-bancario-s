package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import java.util.List;
import java.util.Set;

public class MovimentiAssCpDto {

    private ContoPrestito contoPrestito;
    private Set<MovimentiContoPrestito> movimentiContoPrestito;

    public MovimentiAssCpDto() {
    }

    public MovimentiAssCpDto(ContoPrestito contoPrestito, Set<MovimentiContoPrestito> movimentiContoPrestito) {
        this.contoPrestito = contoPrestito;
        this.movimentiContoPrestito = movimentiContoPrestito;
    }

    public ContoPrestito getContoPrestito() {
        return contoPrestito;
    }

    public void setContoPrestito(ContoPrestito contoPrestito) {
        this.contoPrestito = contoPrestito;
    }

    public Set<MovimentiContoPrestito> getMovimentiContoPrestito() {
        return movimentiContoPrestito;
    }

    public void setMovimentiContoPrestito(Set<MovimentiContoPrestito> movimentiContoPrestito) {
        this.movimentiContoPrestito = movimentiContoPrestito;
    }

    @Override
    public String toString() {
        return "MovimentiAssCpDto{" + "movimentiContoPrestito=" + movimentiContoPrestito + '}';
    }

}
