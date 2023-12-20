package ru.nulfild.courseWork5sem.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long multiplier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plan")
    private List<HouseEntity> houses;

    public PlanEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Long multiplier) {
        this.multiplier = multiplier;
    }
}
