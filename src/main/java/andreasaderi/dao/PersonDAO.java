package andreasaderi.dao;

import andreasaderi.entities.Person;
import andreasaderi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person newPerson) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPerson);
        transaction.commit();
        System.out.println("La persona " + newPerson.getName() + " " + newPerson.getSurname() + " è stata salvata sul DB.");
    }

    public Person findById(String id) {
        Person result = entityManager.find(Person.class, UUID.fromString(id));
        if (result == null) throw new NotFoundException(id);
        return result;
    }
}
