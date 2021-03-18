/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.contocorrentebancarioserver.repository;

import it.sirfin.contocorrentebancarioserver.model.Cliente;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 *
 * @author marco
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCognome(String c);
    
    List<Cliente> findByCognomeContaining(String c);
    
    @Query("select c from Cliente c where cognome = :cogn")
    Collection<Cliente> trovaClientePerCognome(@Param("cogn") String cognome);

    @Query("select c from Cliente c where cognome = :cogn")
    List<Cliente> trovaClientePerCognomeList(@Param("cogn") String cognome);

    @Query("select c from Cliente c where nome in :elenco")
    List<Cliente> trovaClientePerNomeInElenco(
            @Param("elenco") Collection<String> elenco);

    @Query("select c from Cliente c where cognome = :cogn")
    Stream<Cliente> trovaClientePerCognomeStream(@Param("cogn") String cognome);

    @Query("select c from Cliente c")
    List<Cliente> cercaClientiPaginato(Pageable pg);
}
