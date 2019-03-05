package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class EnterprisePhoto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long photoid;

    @Setter
    private String path;

    @ManyToOne
    @Setter
    private Enterprise enterprise;

    public EnterprisePhoto(Enterprise e, String path){
        this.enterprise=e;
        this.path=path;
    }
}
