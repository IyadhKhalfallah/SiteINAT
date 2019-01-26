package inatjunior.website.Entities;

import javax.persistence.*;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Proxy;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Proxy(lazy=false)
public class Training extends Event {

    private String goals;
    private String prerequisites;
    private String equipment;


    public Training(String name, String description, Date opening, Date closing, String place, String goals, String prerequisites, String equipment) {
        super(name, description, opening, closing, place);
        this.goals = goals;
        this.prerequisites = prerequisites;
        this.equipment = equipment;
    }

    @OneToMany(mappedBy = "training")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Trainer> trainers = new ArrayList();

}
