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
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long articleid;

    @Setter
    private String name;

    @Setter
    private Date date;

    @Setter
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String shortdescription;

    @Setter
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String longdescription;

    @OneToMany(mappedBy = "article")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<ArticlePhoto> articlephotos = new ArrayList();

    public Article(String name, Date date, String shortdescription, String longdescription) {
        this.name = name;
        this.date = date;
        this.shortdescription = shortdescription;
        this.longdescription = longdescription;
    }
}
