package springboot.hibernate.service;

import org.springframework.stereotype.Component;
import springboot.hibernate.entity.Climber;
import springboot.hibernate.entity.Route;
import springboot.hibernate.entity.SportRoute;
import springboot.hibernate.entity.TradRoute;
import springboot.hibernate.session.EntityManagerProvider;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Component
public class RepositoryService {

    public void save(Object... objToSave) {
        EntityManager entityManager = EntityManagerProvider.create();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            for (Object singleObject : objToSave) {
                Object saved = entityManager.merge(singleObject);
                System.out.println("Saved object: " + saved.toString());
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List getAll(Class clazz) {
        EntityManager readEntityManager = EntityManagerProvider.create();
        try {
            String query = String.format("select t from %s t", clazz.getSimpleName());
            return readEntityManager.createQuery(query).getResultList();
        } finally {
            readEntityManager.close();
        }
    }

    public Object findById(long id, Class clazz) {
        return EntityManagerProvider.create().find(clazz, id);
    }
}
