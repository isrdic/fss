package rs.srdic.fss.engine.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.srdic.fss.engine.service.UtakmicaService;
import rs.srdic.fss.model.Utakmica;

import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequestMapping(value = "/utakmica")
public class UtakmicaController {

    private final UtakmicaService utakmicaService;

    public UtakmicaController(UtakmicaService utakmicaService) {
        this.utakmicaService = utakmicaService;
    }

    @PostMapping(value = "/save")
    public Utakmica saveUtakmica(@RequestBody Utakmica utakmica) {
        return utakmicaService.saveOrUpdate(utakmica);
    }

    @GetMapping(value = "/get/{utakmicaID}")
    public Utakmica getUtakmica(@PathVariable("utakmicaID") Integer utakmicaID) {
        return utakmicaService.getOne(utakmicaID);
    }

    @PutMapping(value = "/update")
    public Utakmica updateUtakmica(@RequestBody Utakmica utakmica) {
        return utakmicaService.saveOrUpdate(utakmica);
    }

    @DeleteMapping(value = "/delete/utakmicaID")
    public void deleteUtakmica(@PathVariable("utakmicaID") Integer utakmicaID) {
        utakmicaService.delete(utakmicaID);
    }

    @GetMapping(value = "/list")
    public List<Utakmica> findAllUtakmica() {
        return utakmicaService.findAll();
    }

}
