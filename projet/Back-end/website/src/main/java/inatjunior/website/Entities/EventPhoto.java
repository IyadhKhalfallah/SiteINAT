package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class EventPhoto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long photoid;

    @Setter
    private String path;

    @ManyToOne
    @Setter
    private Event event;

    public EventPhoto(Event e, String path){
        this.event=e;
        this.path=path;
    }
}
