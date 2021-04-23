package rs.srdic.fss.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.engine.dto.NastupDTO;
import rs.srdic.fss.engine.service.NastupService;
import rs.srdic.fss.model.Igrac;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;

import java.util.List;

@RestController
@RequestMapping(value = "nastup")
public class NastupController {

    private final NastupService nastupService;

    @Autowired
    public NastupController(NastupService nastupService) {
        this.nastupService = nastupService;
    }

    @PostMapping(value = "/save")
    public Nastup saveNastup(@RequestBody NastupDTO nastupDTO) {
        return nastupService.saveOrUpdate(nastupDTO);
    }

//    @PostMapping("recipe/{id}/image")
//    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
//
//        imageService.saveImageFile(Long.valueOf(id), file);
//
//        return "redirect:/recipe/" + id + "/show";
//    }


    @GetMapping(value = "/get/{igracID}/{utakmicaID}")
    public Nastup getNastup(@PathVariable("igracID") Integer igracID, @PathVariable("utakmicaID") Integer utakmicaID) {
        return nastupService.getOne(new NastupID(igracID, utakmicaID));
    }

//    @PutMapping(value = "/update")
//    public Nastup updateNastup(@RequestBody Nastup nastup) {
//        return nastupService.saveOrUpdate(nastup);
//    }

    @DeleteMapping("/delete/{igracID}/{utakmicaID}")
    public void deleteNastup(@PathVariable("igracID") Integer igracID, @PathVariable("utakmicaID") Integer utakmicaID) {
        nastupService.delete(new NastupID(igracID, utakmicaID));
    }

    @GetMapping("/list")
    public List<Nastup> list() {
        return nastupService.findAll();
    }

}
