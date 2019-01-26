package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Proxy(lazy=false)
public class OfficeMember extends Member {

    private String job;
    private String quote;

    public OfficeMember(String name, String family, String email, Long phone, String job, String quote) {
        super(name, family, email, phone);
        this.job = job;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "OfficeMember{" +
                "job='" + job + '\'' +
                ", quote='" + quote + '\'' +
                "} " + super.toString();
    }
}
