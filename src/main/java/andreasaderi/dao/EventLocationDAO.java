package andreasaderi.dao;

import andreasaderi.entities.EventLocation;
import andreasaderi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventLocationDAO {
    private final EntityManager entityManager;

    public EventLocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(EventLocation newEventLocation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEventLocation);
        transaction.commit();
        System.out.println("L'evento " + newEventLocation.getName() + " è stata salvata sul DB.");
    }

    public EventLocation findById(String id) {
        EventLocation result = entityManager.find(EventLocation.class, UUID.fromString(id));
        if (result == null) throw new NotFoundException(id);
        return result;
    }
}
