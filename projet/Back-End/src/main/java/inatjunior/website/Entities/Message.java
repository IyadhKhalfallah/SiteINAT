package inatjunior.website.Entities;

import lombok.*;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Proxy(lazy=false)
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long messageid;

    @Setter
    private String username;

    @Setter
    private String email;

    @Setter
    private String subject;

    @Setter
    @Column(columnDefinition = "TEXT", length=65535)
    @org.hibernate.annotations.Type( type = "text" )
    private String messagetext;

    public Message(String username, String email, String subject, String messagetext) {
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.messagetext = messagetext;
    }
}
