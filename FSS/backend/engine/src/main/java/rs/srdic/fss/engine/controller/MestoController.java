package rs.srdic.fss.engine.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.srdic.fss.engine.service.MestoService;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequestMapping(value = "/mesto")
public class MestoController {

    private final MestoService mestoService;

    public MestoController(MestoService mestoService) {
        this.mestoService = mestoService;
    }
}
