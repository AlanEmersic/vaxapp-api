package hr.tvz.emersic.vaxapp.service;

import hr.tvz.emersic.vaxapp.DTO.VaccineDTO;
import hr.tvz.emersic.vaxapp.command.VaccineCommand;

import java.util.List;
import java.util.Optional;

public interface VaccineService
{
    List<VaccineDTO> findAll();

    List<VaccineDTO> findVaccinesByResearchName(String query);

    Optional<VaccineDTO> findVaccineByResearchName(String researchName);

    List<VaccineDTO> findVaccineByNumberOfShots(boolean isOneShot);

    Optional<VaccineDTO> save(VaccineCommand vaccineCommand);

    Optional<VaccineDTO> update(String researchName, VaccineCommand vaccineCommand);

    Optional<VaccineDTO> updateNumberOfDoses(String researchName, VaccineCommand vaccineCommand);

    Optional<VaccineDTO> updateNumberOfDoses(String researchName, int numberOfDoses);

    void deleteByResearchName(String researchName);
}
