package hr.tvz.emersic.vaxapp.controller;

import hr.tvz.emersic.vaxapp.DTO.VaccineDTO;
import hr.tvz.emersic.vaxapp.command.VaccineCommand;
import hr.tvz.emersic.vaxapp.service.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "vaccine")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineController {
    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccines() {
        return vaccineService.findAll();
    }

    @GetMapping("/{researchName}")
    public ResponseEntity<VaccineDTO> getVaccineByResearchName(@PathVariable final String researchName) {
        return vaccineService.findVaccineByResearchName(researchName).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/{query}")
    public List<VaccineDTO> getVaccinesByResearchName(@PathVariable final String query) {
        return vaccineService.findVaccinesByResearchName(query);
    }

    @GetMapping(params = "isOneShot")
    public List<VaccineDTO> getVaccineByNumberOfShots(@RequestParam final boolean isOneShot) {
        return vaccineService.findVaccineByNumberOfShots(isOneShot);
    }

    @Secured({"ROLE_ADMIN", "ROLE_CREATOR"})
    @PostMapping
    public ResponseEntity<VaccineDTO> save(@Valid @RequestBody final VaccineCommand vaccineCommand) {
        return vaccineService.save(vaccineCommand)
                .map(vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{researchName}")
    public ResponseEntity<VaccineDTO> update(@PathVariable String researchName, @Valid @RequestBody final VaccineCommand vaccineCommand) {
        return vaccineService.update(researchName, vaccineCommand)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("numberOfDoses/{researchName}")
    public ResponseEntity<VaccineDTO> updateNumberOfDoses(@PathVariable String researchName, @Valid @RequestBody final VaccineCommand vaccineCommand) {
        return vaccineService.updateNumberOfDoses(researchName, vaccineCommand)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "numberOfDosesParam/{researchName}", params = "numberOfDoses")
    public ResponseEntity<VaccineDTO> updateNumberOfDoses(@PathVariable String researchName, @RequestParam final int numberOfDoses) {
        return vaccineService.updateNumberOfDoses(researchName, numberOfDoses)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{researchName}")
    public void delete(@PathVariable String researchName) {
        vaccineService.deleteByResearchName(researchName);
    }
}
