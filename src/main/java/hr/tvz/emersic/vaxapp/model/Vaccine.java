package hr.tvz.emersic.vaxapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Vaccine")
public class Vaccine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Column(name = "research_name")
    private String researchName;
    @Column(name = "number_of_shots")
    private int numberOfShots;
    @Column(name = "available_doses")
    private int availableDoses;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(targetEntity = SideEffect.class, mappedBy = "vaccine",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SideEffect> sideEffects = new ArrayList<>();

    public enum Type {
        MRNA, VIRAL_VECTOR
    }

    public Vaccine(String manufacturerName, String researchName, int numberOfShots,
                   int availableDoses, Type type) {
        this.manufacturerName = manufacturerName;
        this.researchName = researchName;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
        this.type = type;
    }

    public Vaccine(Long id, String manufacturerName, String researchName,
                   int numberOfShots, int availableDoses, Type type) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.researchName = researchName;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
        this.type = type;
    }

    public Vaccine() {

    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public int getAvailableDoses() {
        return availableDoses;
    }

    public void setAvailableDoses(int numberOfDoses) {
        this.availableDoses = numberOfDoses;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type vaccineType) {
        this.type = vaccineType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SideEffect> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffect> sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return researchName.equals(vaccine.researchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(researchName);
    }
}
