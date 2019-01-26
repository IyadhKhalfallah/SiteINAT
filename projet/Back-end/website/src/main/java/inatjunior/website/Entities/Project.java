package inatjunior.website.Entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Proxy;
import java.util.Date;

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
    private String description;

    @Setter
    private Date opening;

    @Setter
    private Date closing;

    public Project(String name, String description, Date opening, Date closing, Enterprise client) {
        this.name = name;
        this.description = description;
        this.opening = opening;
        this.closing = closing;
        this.client=client;
    }

    @ManyToOne
    @Setter
    private Enterprise client;
}
