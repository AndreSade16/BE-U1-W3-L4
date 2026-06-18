package andreasaderi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashSet;

@Entity
@Table(name = "athletics_races")
public class AthleticsRace extends Evento {
    private HashSet<Person> athletes;
    @ManyToOne
    @JoinColumn(name = "winning_person_id")
    private Person winner;

    public AthleticsRace() {
    }

    public AthleticsRace(String title, LocalDate date, String description, EventType eventType, int maxPartecipants, EventLocation eventLocation, HashSet<Person> athletes, Person winner) {
        super(title, date, description, eventType, maxPartecipants, eventLocation);
        this.athletes = athletes;
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsRace{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxPartecipants=" + maxPartecipants +
                ", eventLocation=" + eventLocation +
                '}';
    }
}
