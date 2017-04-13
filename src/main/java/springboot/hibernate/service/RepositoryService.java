package springboot.hibernate.service;

import org.springframework.stereotype.Component;
import springboot.hibernate.entity.Climber;
import springboot.hibernate.session.EntityManagerProvider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class RepositoryService {

    public void testCriteriaBuilder() {
        EntityManager entityManager = EntityManagerProvider.create();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Climber> query = cb.createQuery(Climber.class);
        Root<Climber> climber = query.from(Climber.class);
        CriteriaQuery<Climber> query1 = query.select(climber).where(cb.equal(climber.get("id"), 1));
    }

    public Object save(Object objToSave) {
        EntityManager entityManager = EntityManagerProvider.create();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Object saved = entityManager.merge(objToSave);
            System.out.println("Saved object: " + saved.toString());
            transaction.commit();
            return saved;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
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

    public <T> List<T> executeQuery(CriteriaQuery<T> criteriaQuery) {
        EntityManager entityManager = EntityManagerProvider.create();
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List executeQuery(String jpqlQueryString) {
        EntityManager entityManager = EntityManagerProvider.create();
        Query query = entityManager.createQuery(jpqlQueryString);
        return query.getResultList();
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return EntityManagerProvider.create().getCriteriaBuilder();
    }

    public Object findById(long id, Class clazz) {
        return EntityManagerProvider.create().find(clazz, id);
    }

    public List executeNamedQuery(String namedQuery, Object... queryParams) {
        EntityManager entityManager = EntityManagerProvider.create();
        Query query = entityManager.createNamedQuery(namedQuery);
        for (int i = 0; i < queryParams.length; i++) {
            query = query.setParameter(i, queryParams[i]);
        }
        return query.getResultList();
    }
}
