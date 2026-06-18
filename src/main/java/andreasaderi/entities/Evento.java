package andreasaderi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "eventi")
public abstract class Evento {
    @Id
    @GeneratedValue
    @Column(name = "event_id")
    protected UUID id;
    protected String title;
    protected LocalDate date;
    protected String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    protected EventType eventType;
    @Column(name = "max_partecipants")
    protected int maxPartecipants;
    @ManyToOne
    @JoinColumn(name = "location_id")
    protected EventLocation eventLocation;

    public Evento() {
    }

    public Evento(String title, LocalDate date, String description, EventType eventType, int maxPartecipants, EventLocation eventLocation) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.eventType = eventType;
        this.maxPartecipants = maxPartecipants;
        this.eventLocation = eventLocation;
    }

    public String getTitle() {
        return title;
    }
}
