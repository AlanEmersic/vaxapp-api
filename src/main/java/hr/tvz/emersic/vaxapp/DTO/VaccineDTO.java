package hr.tvz.emersic.vaxapp.DTO;

import hr.tvz.emersic.vaxapp.model.Vaccine;

public class VaccineDTO
{
    private final String manufacturerName;
    private final String researchName;
    private final int numberOfShots;
    private final int availableDoses;
    private final Vaccine.Type type;

    public VaccineDTO(String manufacturerName, String researchName, int numberOfShots, int availableDoses, Vaccine.Type type) {
        this.manufacturerName = manufacturerName;
        this.researchName = researchName;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
        this.type = type;
    }

    public String getManufacturerName()
    {
        return manufacturerName;
    }

    public String getResearchName()
    {
        return researchName;
    }

    public int getNumberOfShots()
    {
        return numberOfShots;
    }

    public int getAvailableDoses() {
        return availableDoses;
    }

    public Vaccine.Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "VaccineDTO{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", researchName='" + researchName + '\'' +
                ", numberOfShots=" + numberOfShots +
                ", availableDoses=" + availableDoses +
                ", type=" + type +
                '}';
    }
}
