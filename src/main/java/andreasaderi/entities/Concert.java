package andreasaderi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Evento {
    private ConcertGenre genre;
    private boolean isInStreaming;

    public Concert(String title, LocalDate date, String description, EventType eventType, int maxPartecipants, EventLocation eventLocation, ConcertGenre genre, boolean isInStreaming) {
        super(title, date, description, eventType, maxPartecipants, eventLocation);
        this.genre = genre;
        this.isInStreaming = isInStreaming;
    }

    protected Concert() {

    }

    @Override
    public String toString() {
        return "Concert{" +
                "genre=" + genre +
                ", isInStreaming=" + isInStreaming +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", eventLocation=" + eventLocation +
                ", maxPartecipants=" + maxPartecipants +
                '}';
    }
}
