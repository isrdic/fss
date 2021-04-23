package rs.srdic.fss.engine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.engine.service.IgracService;
import rs.srdic.fss.model.Igrac;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/igrac")
public class IgracController {

    private final ObjectMapper objectMapper;
    private final IgracService igracService;

    public IgracController(ObjectMapper objectMapper, IgracService igracService) {
        this.objectMapper = objectMapper;
        this.igracService = igracService;
    }

    @PostMapping(value = "/save", consumes = MediaType.ALL_VALUE)
    public IgracDTO saveIgrac(@RequestParam(value = "igracDTOSJson") String igracDTOSJson, @RequestParam(value = "slika") MultipartFile slika) {

        try {
            IgracDTO igracDTO = objectMapper.readValue(igracDTOSJson, IgracDTO.class);
            igracDTO.setSlika(slika.getBytes());
            return igracService.save(igracDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
        return igracService.update(igracDTO);
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
