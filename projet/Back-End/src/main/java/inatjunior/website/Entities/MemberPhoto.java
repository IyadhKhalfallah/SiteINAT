package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class MemberPhoto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long photoid;

    @Setter
    private String path;

    @ManyToOne
    @Setter
    private Member member;

    public MemberPhoto(Member e, String path){
        this.member=e;
        this.path=path;
    }
}
