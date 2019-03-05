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
public class Enterprise {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long enterpriseid;

    @Setter
    private String name;

    @Setter
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String description;

    @Setter
    private String email;

    @Setter
    private Long phone;

    @Setter
    private String address;

    @Setter
    private boolean partner;

    @Setter
    private boolean sponsor;

    public Enterprise(String name, String description, String email, Long phone, String address, boolean partner, boolean sponsor) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.partner = partner;
        this.sponsor = sponsor;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "client")
    @JsonIgnore
    private List<Project> projects = new ArrayList();

    @OneToMany(mappedBy = "enterprise")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<EnterprisePhoto> enterprisephotos = new ArrayList();
}
