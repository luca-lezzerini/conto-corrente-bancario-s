/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.repository;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Palo
 */
public interface MovimentiContoDepositoRepository extends JpaRepository<MovimentiContoDeposito, Long> {

}
