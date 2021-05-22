package hr.tvz.emersic.vaxapp.service;

import hr.tvz.emersic.vaxapp.DTO.VaccineDTO;
import hr.tvz.emersic.vaxapp.command.VaccineCommand;
import hr.tvz.emersic.vaxapp.model.Vaccine;
import hr.tvz.emersic.vaxapp.repository.VaccineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImpl implements VaccineService {
    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepository.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public List<VaccineDTO> findVaccinesByResearchName(String query) {
        return vaccineRepository.findVaccinesByResearchName(query).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VaccineDTO> findVaccineByResearchName(final String researchName) {
        return vaccineRepository.findVaccineByResearchName(researchName).map(this::mapVaccineToDTO);
    }

    @Override
    public List<VaccineDTO> findVaccineByNumberOfShots(final boolean isOneShot) {
        return vaccineRepository.findVaccineByNumberOfShots(isOneShot).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VaccineDTO> save(final VaccineCommand vaccineCommand) {
        return vaccineRepository.save(mapCommandToVaccine(vaccineCommand)).map(this::mapVaccineToDTO);
    }

    @Override
    public Optional<VaccineDTO> update(final String researchName, final VaccineCommand vaccineCommand) {
        return vaccineRepository.update(researchName, mapCommandToVaccine(vaccineCommand)).map(this::mapVaccineToDTO);
    }

    @Override
    public Optional<VaccineDTO> updateNumberOfDoses(final String researchName, final VaccineCommand vaccineCommand) {
        return vaccineRepository.updateNumberOfDoses(researchName, mapCommandToVaccine(vaccineCommand)).map(this::mapVaccineToDTO);
    }

    @Override
    public Optional<VaccineDTO> updateNumberOfDoses(final String researchName, final int numberOfDoses) {
        return vaccineRepository.updateNumberOfDoses(researchName, numberOfDoses).map(this::mapVaccineToDTO);
    }

    @Override
    public void deleteByResearchName(final String researchName) {
        vaccineRepository.deleteByResearchName(researchName);
    }

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine) {
        return new VaccineDTO(vaccine.getManufacturerName(), vaccine.getResearchName(), vaccine.getNumberOfShots(),
                vaccine.getAvailableDoses(), vaccine.getType());
    }

    private Vaccine mapCommandToVaccine(final VaccineCommand vaccineCommand) {
        return new Vaccine(vaccineCommand.getManufacturerName(), vaccineCommand.getResearchName(), vaccineCommand.getNumberOfShots(), vaccineCommand.getAvailableDoses(), vaccineCommand.getType());
    }
}
