/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author marco
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
     @Column
    private String cognome;
    @Column
    private String codiceFiscale;
    @Column
    private String indirizzo;
    @Column
    private String telefono;
    
    
   

}
