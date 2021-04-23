package rs.srdic.fss.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.engine.dto.NastupDTO;
import rs.srdic.fss.engine.service.NastupService;
import rs.srdic.fss.model.Igrac;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;
import rs.srdic.fss.model.Utakmica;

import java.util.List;

@RestController
@RequestMapping(value = "nastup")
public class NastupController {

    private final NastupService nastupService;

    @Autowired
    public NastupController(NastupService nastupService) {
        this.nastupService = nastupService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(value = "/save")
    public Nastup saveNastup(@RequestBody NastupDTO nastupDTO) {
        return nastupService.saveOrUpdate(nastupDTO);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(value = "/get/{igracID}/{utakmicaID}")
    public Nastup getNastup(@PathVariable("igracID") Integer igracID, @PathVariable("utakmicaID") Integer utakmicaID) {
        return nastupService.getOne(new NastupID(igracID, utakmicaID));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping(value = "/update")
    public Nastup updateNastup(@RequestBody NastupDTO nastupDTO) {
        return nastupService.saveOrUpdate(nastupDTO);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{igracID}/{utakmicaID}")
    public void deleteNastup(@PathVariable("igracID") Integer igracID, @PathVariable("utakmicaID") Integer utakmicaID) {
        nastupService.delete(new NastupID(igracID, utakmicaID));
    }

    @PreAuthorize("hasAnyAuthority('IGRAC')")
    @GetMapping("/list/{jmbg}")
    public List<Utakmica> list(@PathVariable("jmbg") String jmbg) {
        return nastupService.findAll(jmbg);
    }

}
