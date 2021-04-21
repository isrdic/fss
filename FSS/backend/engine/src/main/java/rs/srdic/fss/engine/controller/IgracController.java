package rs.srdic.fss.engine.controller;

import org.springframework.web.bind.annotation.*;
import rs.srdic.fss.engine.service.IgracService;
import rs.srdic.fss.model.Igrac;

import java.util.List;

@RestController
@RequestMapping(value = "/igrac")
public class IgracController {

    private final IgracService igracService;

    public IgracController(IgracService igracService) {
        this.igracService = igracService;
    }

    @PostMapping(value = "/save")
    public Igrac saveIgrac(@RequestBody Igrac igrac) {
        return igracService.saveOrUpdate(igrac);
    }

    @GetMapping(value = "/get/{igracID}")
    public Igrac getIgrac(@PathVariable("igracID") Integer igracID) {
        return igracService.getOne(igracID);
    }

    @PutMapping(value = "/update")
    public Igrac updateIgrac(@RequestBody Igrac igrac) {
        return igracService.saveOrUpdate(igrac);
    }

    @DeleteMapping("/delete/{igracID}")
    public void deleteIgrac(@PathVariable("igracID") Integer igracID) {
        igracService.delete(igracID);
    }

    @GetMapping("/list")
    public List<Igrac> list() {
        return igracService.findAll();
    }

}
