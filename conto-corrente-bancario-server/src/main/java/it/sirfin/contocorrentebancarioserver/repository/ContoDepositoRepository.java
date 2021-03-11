/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.repository;

import it.sirfin.contocorrentebancarioserver.model.ContoDeposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public interface ContoDepositoRepository extends JpaRepository<ContoDeposito, Long>{
    
}
