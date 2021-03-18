package it.sirfin.contocorrentebancarioserver.controller;

import it.sirfin.contocorrentebancarioserver.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class SystemAdminController {

    @Autowired
    SystemAdminService systemAdminService;

    @RequestMapping("/query-annotation")
    public void queryAnnotation() {
        systemAdminService.queryAnnotation();
    }
}
