
package it.sirfin.contocorrentebancarioserver.dto;

import it.sirfin.contocorrentebancarioserver.model.ContoPrestito;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoPrestito;
import java.util.List;

public class MovimentiAssCpDto {
    
    private  ContoPrestito contoPrestito;
    private List<MovimentiContoPrestito> movimentiContoPrestito;

    public MovimentiAssCpDto() {
    }

    public MovimentiAssCpDto(ContoPrestito contoPrestito, List<MovimentiContoPrestito> movimentiContoPrestito) {
        this.contoPrestito = contoPrestito;
        this.movimentiContoPrestito = movimentiContoPrestito;
    }

    public ContoPrestito getContoPrestito() {
        return contoPrestito;
    }

    public void setContoPrestito(ContoPrestito contoPrestito) {
        this.contoPrestito = contoPrestito;
    }

    public List<MovimentiContoPrestito> getMovimentiContoPrestito() {
        return movimentiContoPrestito;
    }

    public void setMovimentiContoPrestito(List<MovimentiContoPrestito> movimentiContoPrestito) {
        this.movimentiContoPrestito = movimentiContoPrestito;
    }

    @Override
    public String toString() {
        return "MovimentiAssCpDto{" + "movimentiContoPrestito=" + movimentiContoPrestito + '}';
    }
    
    

}
