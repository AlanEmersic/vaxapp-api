package hr.tvz.emersic.vaxapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "side_effect")
public class SideEffect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "short_description")
    private String shortDescription;
    private String description;
    private float frequency;

    @ManyToOne(targetEntity = Vaccine.class)
    @JoinColumn(name = "vaccine")
    private Vaccine vaccine;

    public SideEffect() {

    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String longDescription) {
        this.description = longDescription;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float rate) {
        this.frequency = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
