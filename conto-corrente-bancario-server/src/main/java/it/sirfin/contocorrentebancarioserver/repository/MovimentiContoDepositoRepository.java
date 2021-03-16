/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.repository;

import it.sirfin.contocorrentebancarioserver.model.MovimentiContoDeposito;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Palo
 */
@Repository
public interface MovimentiContoDepositoRepository extends JpaRepository<MovimentiContoDeposito, Long> {

    Set<MovimentiContoDeposito> findByContoDepositoId(Long l);
}
