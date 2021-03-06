package hr.tvz.emersic.vaxapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Authority")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
