package inatjunior.website.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy=false)
public class Trainer {

    @EmbeddedId
    private TrainerKey id;

    @ManyToOne
    @MapsId("eventid")
    @JoinColumn(name = "eventid")
    Training training;

    @ManyToOne
    @MapsId("memberid")
    @JoinColumn(name = "memberid")
    Member member;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer that = (Trainer) o;
        return Objects.equals(member.getMemberid(), that.getMember().getMemberid()) &&
                Objects.equals(training.getEventid(), that.getTraining().getEventid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(member.getMemberid(), training.getEventid());
    }

}
