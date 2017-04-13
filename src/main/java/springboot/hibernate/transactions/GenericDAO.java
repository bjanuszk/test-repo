package springboot.hibernate.transactions;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class GenericDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Object save(Object objToSave) {
        try {
            Object saved = entityManager.merge(objToSave);
            return saved;
        } finally {
            entityManager.close();
        }
    }

    public Object findById(long id, Class clazz) {
        return entityManager.find(clazz, id);
    }
}
