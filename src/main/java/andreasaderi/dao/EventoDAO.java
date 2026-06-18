package andreasaderi.dao;

import andreasaderi.entities.Evento;
import andreasaderi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvento);
        transaction.commit();
        System.out.println("L'evento " + newEvento.getTitle() + " è stato salvato sul DB.");
    }

    public Evento findById(String id) {
        Evento result = entityManager.find(Evento.class, UUID.fromString(id));
        if (result == null) throw new NotFoundException(id);
        return result;
    }

}
