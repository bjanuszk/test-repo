package springboot.hibernate.session;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    public static EntityManager create() {
        return Persistence.createEntityManagerFactory("cyfraPU").createEntityManager();
    }
}
