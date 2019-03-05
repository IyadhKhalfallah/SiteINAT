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
public class Member {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long memberid;

    @Setter
    private String name;

    @Setter
    private String family;

    @Setter
    private String email;

    @Setter
    private Long phone;

    @Setter
    private String job;

    @Setter
    private String quote;

    @Setter
    private boolean office;

    public Member(String name, String family, String email, Long phone, String job, String quote, boolean office) {
        this.name = name;
        this.family = family;
        this.email = email;
        this.phone = phone;
        this.job = job;
        this.quote = quote;
        this.office=office;
    }

    @OneToMany(mappedBy = "member")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Trainer> trainers = new ArrayList();

    @OneToMany(mappedBy = "member")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Organizer> organizers = new ArrayList();

    @OneToMany(mappedBy = "member")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<MemberPhoto> memberphotos = new ArrayList();
}
