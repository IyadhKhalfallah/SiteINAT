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

    public Member(String name, String family, String email, Long phone) {
        this.name = name;
        this.family = family;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberid=" + memberid +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }

    @OneToMany(mappedBy = "member")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Trainer> trainers = new ArrayList();

    @OneToMany(mappedBy = "member")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<Organizer> organizers = new ArrayList();
}
