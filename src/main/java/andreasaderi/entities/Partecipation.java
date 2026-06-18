package andreasaderi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipations")
public class Partecipation {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento event;
    @Enumerated(EnumType.STRING)
    private PartecipationState state;

    protected Partecipation() {
    }

    public Partecipation(Person person, Evento event, PartecipationState state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public Evento getEvent() {
        return event;
    }
}
