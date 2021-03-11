package it.sirfin.contocorrentebancarioserver.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class Cliente implements Serializable {

    private String telefono;
    @OneToMany(mappedBy = "cliente")
    private Set<ContoCorrente> contiCorrente;
    @OneToMany(mappedBy = "cliente")
    private Set<ContoPrestito> contiPrestito;
    @OneToMany(mappedBy = "cliente")
    private Set<ContoDeposito> contiDeposito;

    public Cliente() {
    }

    public Set<ContoCorrente> getContiCorrente() {
        if (contiCorrente == null) {
            contiCorrente = new HashSet<>();
        }
        return contiCorrente;
    }

    public void setContiCorrente(Set<ContoCorrente> contiCorrente) {
        if (contiCorrente == null) {
            contiCorrente = new HashSet<>();
        }
        this.contiCorrente = contiCorrente;
    }

    public Set<ContoPrestito> getContiPrestito() {
        if (contiPrestito == null) {
            contiPrestito = new HashSet<>();
        }
        return contiPrestito;
    }

    public void setContiPrestito(Set<ContoPrestito> contiPrestito) {
        if (contiPrestito == null) {
            contiPrestito = new HashSet<>();
        }
        this.contiPrestito = contiPrestito;
    }

    public Set<ContoDeposito> getContiDeposito() {
        if (contiDeposito == null) {
            contiDeposito = new HashSet<>();
        }
        return contiDeposito;
    }

    public void setContiDeposito(Set<ContoDeposito> contiDeposito) {
        if (contiDeposito == null) {
            contiDeposito = new HashSet<>();
        }
        this.contiDeposito = contiDeposito;
    }

}
