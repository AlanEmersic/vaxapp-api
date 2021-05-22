package hr.tvz.emersic.vaxapp.DTO;

public class SideEffectDTO
{
    private final String shortDescription;
    private final String description;
    private final float frequency;

    public SideEffectDTO(String shortDescription, String description, float frequency)
    {
        this.shortDescription = shortDescription;
        this.description = description;
        this.frequency = frequency;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public float getFrequency()
    {
        return frequency;
    }
}
