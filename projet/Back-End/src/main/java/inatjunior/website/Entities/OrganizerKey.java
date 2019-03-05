package inatjunior.website.Entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerKey implements Serializable {

    @Column(name = "memberid")
    Long memberId;

    @Column(name = "eventid")
    Long eventid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizerKey)) return false;
        OrganizerKey that = (OrganizerKey) o;
        return Objects.equals(this.getMemberId(), that.getMemberId()) &&
                Objects.equals(this.getEventid(), that.getEventid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getMemberId(), this.getEventid());
    }

}