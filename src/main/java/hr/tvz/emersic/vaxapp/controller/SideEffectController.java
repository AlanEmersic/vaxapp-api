package hr.tvz.emersic.vaxapp.controller;

import hr.tvz.emersic.vaxapp.DTO.SideEffectDTO;
import hr.tvz.emersic.vaxapp.service.SideEffectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "side-effect")
@CrossOrigin(origins = "http://localhost:4200")
public class SideEffectController
{
    private final SideEffectService sideEffectService;

    public SideEffectController(SideEffectService sideEffectService)
    {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping
    public List<SideEffectDTO> getAllSideEffects()
    {
        return sideEffectService.findAll();
    }

    @GetMapping(params = "vaccineResearchName")
    public List<SideEffectDTO> getAllSideEffectsByResearchName(@RequestParam String vaccineResearchName)
    {
        return sideEffectService.findAllByResearchName(vaccineResearchName);
    }
}
