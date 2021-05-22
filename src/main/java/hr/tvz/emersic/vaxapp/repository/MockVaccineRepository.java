//package hr.tvz.emersic.vaxapp.repository;
//
//import hr.tvz.emersic.vaxapp.model.Vaccine;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Repository
//public class MockVaccineRepository implements VaccineRepository
//{
////    private final List<Vaccine> mockedVaccine = new ArrayList<Vaccine>(
////            Arrays.asList(
////                    new Vaccine("Pfizer", "BNT162B2", 2, 100, Vaccine.Type.ViralVector),
////                    new Vaccine("AstraZeneca", "AZD1222", 1, 200, Vaccine.Type.ViralVector),
////                    new Vaccine("Moderna", "MRNA-1273", 2, 5000, Vaccine.Type.RNA),
////                    new Vaccine("Johnson & Johnson", "JNJ-78436735", 1, 2000, Vaccine.Type.RNA)
////            )
////    );
//
//    @Override
//    public List<Vaccine> findAll()
//    {
//        return mockedVaccine;
//    }
//
//    @Override
//    public List<Vaccine> findVaccinesByResearchName(String query)
//    {
//        return mockedVaccine.stream().filter(vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), query.toLowerCase())).collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<Vaccine> findVaccineByResearchName(final String researchName)
//    {
//        return mockedVaccine.stream().filter(vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), researchName.toLowerCase())).findFirst();
//    }
//
//    @Override
//    public List<Vaccine> findVaccineByNumberOfShots(final boolean isOneShot)
//    {
//        return isOneShot == true ?
//                mockedVaccine.stream().filter(vaccine -> Objects.equals(vaccine.getNumberOfShots(), 1)).collect(Collectors.toList())
//                : mockedVaccine.stream().filter(vaccine -> !Objects.equals(vaccine.getNumberOfShots(), 1)).collect(Collectors.toList());
//
//    }
//
//    @Override
//    public Optional<Vaccine> save(final Vaccine vaccine)
//    {
//        boolean checkVaccine = mockedVaccine.stream().anyMatch(v -> v.getResearchName().toLowerCase().equals(vaccine.getResearchName().toLowerCase()));
//
//        if (!checkVaccine)
//        {
//            mockedVaccine.add(vaccine);
//            return Optional.of(vaccine);
//        } else
//        {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public Optional<Vaccine> update(final String researchName, final Vaccine updateVaccine)
//    {
//        boolean exists = mockedVaccine.removeIf(
//                vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), researchName.toLowerCase())
//                        && Objects.equals(vaccine.getResearchName().toLowerCase(), updateVaccine.getResearchName().toLowerCase())
//        );
//
//        if (exists)
//        {
//            mockedVaccine.add(updateVaccine);
//            return Optional.of(updateVaccine);
//        } else
//        {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public Optional<Vaccine> updateNumberOfDoses(final String researchName, final Vaccine updateVaccine)
//    {
//        boolean exists = mockedVaccine.removeIf(
//                vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), researchName.toLowerCase())
//                        && Objects.equals(vaccine.getResearchName().toLowerCase(), updateVaccine.getResearchName().toLowerCase())
//                        && Objects.equals(vaccine.getType().toString().toLowerCase(), updateVaccine.getType().toString().toLowerCase())
//                        && Objects.equals(vaccine.getManufacturerName().toLowerCase(), updateVaccine.getManufacturerName().toLowerCase())
//                        && vaccine.getNumberOfShots() == updateVaccine.getNumberOfShots()
//        );
//
//        if (exists)
//        {
//            mockedVaccine.add(updateVaccine);
//            return Optional.of(updateVaccine);
//        } else
//        {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public Optional<Vaccine> updateNumberOfDoses(final String researchName, final int numberOfDoses)
//    {
//        Vaccine updateVaccine = mockedVaccine.stream().filter(vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), researchName.toLowerCase())).findFirst().get();
//
//        if (updateVaccine != null)
//        {
//            updateVaccine.setAvailableDoses(numberOfDoses);
//            return Optional.of(updateVaccine);
//        } else
//        {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public void deleteByResearchName(final String researchName)
//    {
//        mockedVaccine.removeIf(vaccine -> Objects.equals(vaccine.getResearchName().toLowerCase(), researchName.toLowerCase()));
//    }
//}
