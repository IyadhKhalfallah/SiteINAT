package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy=false)
public class Organizer {

    @EmbeddedId
    private OrganizerKey id;

    @ManyToOne
    @MapsId("eventid")
    @JoinColumn(name = "eventid")
    Event event;

    @ManyToOne
    @MapsId("memberid")
    @JoinColumn(name = "memberid")
    Member member;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organizer)) return false;
        Organizer that = (Organizer) o;
        return Objects.equals(member.getMemberid(), that.getMember().getMemberid()) &&
                Objects.equals(event.getEventid(), that.getEvent().getEventid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(member.getMemberid(), event.getEventid());
    }

}
