package andreasaderi.dao;

import andreasaderi.entities.Partecipation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipationDAO {
    private final EntityManager entityManager;

    public PartecipationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipation newPartecipation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPartecipation);
        transaction.commit();
        System.out.println("La partecipazione di" + newPartecipation.getPerson().getName() + " " + newPartecipation.getPerson().getSurname() + " all'evento " + newPartecipation.getEvent().getTitle() + " presso " + newPartecipation.getEvent().getEventLocation().getName() + " è stata salvata sul DB.");
    }


}
