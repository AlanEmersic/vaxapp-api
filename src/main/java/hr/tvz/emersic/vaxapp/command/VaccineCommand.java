package hr.tvz.emersic.vaxapp.command;

import hr.tvz.emersic.vaxapp.model.Vaccine;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VaccineCommand {
    @NotBlank(message = "Manufacturer name must not be empty")
    private String manufacturerName;

    @NotBlank(message = "Research name must not be empty")
    private String researchName;

    @NotNull(message = "Number of shots must not be empty")
    @Positive(message = "Number must be positive")
    private int numberOfShots;

    @NotNull(message = "Number of doses must not be empty")
    @Positive(message = "Number must be positive")
    private int availableDoses;

    @NotNull(message = "Vaccine type must not be empty")
    private Vaccine.Type type;

    public enum Type {
        MRNA, VIRAL_VECTOR
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getResearchName() {
        return researchName;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public int getAvailableDoses() {
        return availableDoses;
    }

    public Vaccine.Type getType() {
        return type;
    }
}
