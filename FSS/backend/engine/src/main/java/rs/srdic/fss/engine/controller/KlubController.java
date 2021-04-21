package rs.srdic.fss.engine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.srdic.fss.engine.service.KlubService;

@RestController
@RequestMapping(value = "/klub")
public class KlubController {

    private final KlubService klubServicel;

    public KlubController(KlubService klubServicel) {
        this.klubServicel = klubServicel;
    }
}
