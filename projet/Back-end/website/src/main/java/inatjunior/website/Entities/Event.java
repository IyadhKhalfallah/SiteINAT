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
@NoArgsConstructor
@Proxy(lazy=false)
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long eventid;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Date opening;

    @Setter
    private Date closing;

    @Setter
    private String place;

    public Event(String name, String description, Date opening, Date closing, String place) {
        this.name = name;
        this.description = description;
        this.opening = opening;
        this.closing = closing;
        this.place = place;
    }

    @OneToMany(mappedBy = "event")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Organizer> organizers = new ArrayList();
}
