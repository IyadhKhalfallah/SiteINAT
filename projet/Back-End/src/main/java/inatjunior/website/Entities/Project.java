package inatjunior.website.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import java.util.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long projectid;

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
    private boolean academic;

    public Project(String name, String description, Date opening, Date closing, boolean academic, Enterprise client) {
        this.name = name;
        this.description = description;
        this.opening = opening;
        this.closing = closing;
        this.academic = academic;
        this.client=client;
    }

    @ManyToOne
    @Setter
    private Enterprise client;

    @OneToMany(mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<ProjectPhoto> projectphotos = new ArrayList();
}
