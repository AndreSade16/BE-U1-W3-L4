package andreasaderi.dao;

import andreasaderi.entities.Concert;
import andreasaderi.entities.Evento;
import andreasaderi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Concert> getConcertsInStreaming() {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE isInStreaming = true", Concert.class);
        return query.getResultList();
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
