package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class ProjectPhoto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long photoid;

    @Setter
    private String path;

    @ManyToOne
    @Setter
    private Project project;

    public ProjectPhoto(Project e, String path){
        this.project=e;
        this.path=path;
    }
}
