package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class ArticlePhoto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long photoid;

    @Setter
    private String path;

    @ManyToOne
    @Setter
    private Article article;

    public ArticlePhoto(Article e, String path){
        this.article=e;
        this.path=path;
    }
}
