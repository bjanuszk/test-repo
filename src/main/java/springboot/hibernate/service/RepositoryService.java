package springboot.hibernate.service;

import org.springframework.stereotype.Component;
import springboot.hibernate.session.EntityManagerProvider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Component
public class RepositoryService {

    public void save(Object objToSave) {
        EntityManager entityManager = EntityManagerProvider.create();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Object saved = entityManager.merge(objToSave);
            System.out.println("Saved object: " + saved.toString());
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
}
