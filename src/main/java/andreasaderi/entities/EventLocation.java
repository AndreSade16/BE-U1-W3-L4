package andreasaderi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "event_locations")
public class EventLocation {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String city;

    protected EventLocation() {
    }

    public EventLocation(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }
}
