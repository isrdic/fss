package rs.srdic.fss.engine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.srdic.fss.engine.service.MestoService;

@RestController
@RequestMapping(value = "/mesto")
public class MestoController {

    private final MestoService mestoService;

    public MestoController(MestoService mestoService) {
        this.mestoService = mestoService;
    }
}
