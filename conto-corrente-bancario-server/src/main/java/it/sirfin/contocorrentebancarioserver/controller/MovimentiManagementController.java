package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.service.MovimentiManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MovimentiManagementController {

    @Autowired
    MovimentiManagementService movimentiManagementService;
}
