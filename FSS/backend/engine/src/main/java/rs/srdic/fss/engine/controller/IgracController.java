package rs.srdic.fss.engine.controller;

import org.springframework.web.bind.annotation.*;
import rs.srdic.fss.engine.dto.IgracDTO;
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
    public IgracDTO saveIgrac(@RequestBody IgracDTO igracDTO) {
        return igracService.saveOrUpdate(igracDTO);
    }

//    @PostMapping("recipe/{id}/image")
//    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
//
//        imageService.saveImageFile(Long.valueOf(id), file);
//
//        return "redirect:/recipe/" + id + "/show";
//    }


    @GetMapping(value = "/get/{igracID}")
    public Igrac getIgrac(@PathVariable("igracID") Integer igracID) {
        return igracService.getOne(igracID);
    }

    @PutMapping(value = "/update")
    public IgracDTO updateIgrac(@RequestBody IgracDTO igracDTO) {
        return igracService.saveOrUpdate(igracDTO);
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
