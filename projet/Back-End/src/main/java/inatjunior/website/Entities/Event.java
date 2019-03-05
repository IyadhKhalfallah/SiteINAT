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
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String description;

    @Setter
    private Date opening;

    @Setter
    private Date closing;

    @Setter
    private String place;

    @Setter
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String program;

    public Event(String name, String description, Date opening, Date closing, String place, String program) {
        this.name = name;
        this.description = description;
        this.opening = opening;
        this.closing = closing;
        this.place = place;
        this.program = program;
    }

    @OneToMany(mappedBy = "event")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Organizer> organizers = new ArrayList();

    @OneToMany(mappedBy = "event")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<EventPhoto> eventphotos = new ArrayList();
}
