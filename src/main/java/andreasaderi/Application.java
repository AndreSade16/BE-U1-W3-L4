package andreasaderi;

import andreasaderi.dao.EventLocationDAO;
import andreasaderi.dao.EventoDAO;
import andreasaderi.dao.PartecipationDAO;
import andreasaderi.dao.PersonDAO;
import andreasaderi.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1w3l4pu");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        PersonDAO personDAO = new PersonDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        EventLocationDAO eventLocationDAO = new EventLocationDAO(em);
        PartecipationDAO partecipationDAO = new PartecipationDAO(em);

//        personDAO.save(new Person("Andrea", "Saderi", "andrea.saderi@gmail.com", LocalDate.of(1996, 5, 28), Sex.M));
        EventLocation sanSiro = new EventLocation("San Siro", "Milano");
//        eventLocationDAO.save(sanSiro);
        EventLocation sanSiroFromDb = eventLocationDAO.findById("b67228db-c194-42e7-8d61-fd1e73de4e94");
//        eventoDAO.save(new Concert("Elettrica Live", LocalDate.of(2026, 6, 20), "Elettrica live a Milano!", EventType.PUBLIC, 300, sanSiroFromDb, ConcertGenre.ROCK, false));
        Person andreFromDb = personDAO.findById("addcba23-918b-4be3-afd0-ea1d0944e705");
        Evento elettricaLiveFromDb = eventoDAO.findById("e00896be-6774-4afe-93dd-91ab0580b782");
        partecipationDAO.save(new Partecipation(andreFromDb, elettricaLiveFromDb, PartecipationState.CONFIRMED));
    }

}
