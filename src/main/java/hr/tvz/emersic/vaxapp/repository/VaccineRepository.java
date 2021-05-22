package hr.tvz.emersic.vaxapp.repository;

import hr.tvz.emersic.vaxapp.model.Vaccine;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository
{
    List<Vaccine> findAll();

    List<Vaccine> findVaccinesByResearchName(String query);

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByNumberOfShots(boolean isOneShot);

    Optional<Vaccine> save(Vaccine vaccine);

    Optional<Vaccine> update(String researchName, Vaccine updateVaccine);

    Optional<Vaccine> updateNumberOfDoses(String researchName, Vaccine updateVaccine);

    Optional<Vaccine> updateNumberOfDoses(String researchName, int numberOfDoses);

    void deleteByResearchName(String researchName);
}
