/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author marco
 */
@Entity
public class MovimentoGenerico {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate dataMov;
    @Column
    private String tipoMovimento;
    @Column
    private double importo;

}
