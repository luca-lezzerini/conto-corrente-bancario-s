/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.repository;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import it.sirfin.contocorrentebancarioserver.model.MovimentiContoCorrente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author feder
 */
@Repository
public interface MovimentiContoCorrenteRepository extends JpaRepository<MovimentiContoCorrente, Long>{
   // List<Cliente> findByCognomeContaining(String c);
}
