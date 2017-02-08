package springboot.hibernate.service;

import org.springframework.stereotype.Component;
import springboot.hibernate.entity.Message;
import springboot.hibernate.session.EntityManagerProvider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Component
public class MessageService {

    public void saveMessage(Message message) {
        EntityManager entityManager = EntityManagerProvider.create();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Message ahoj = entityManager.merge(message);
            System.out.println("Saved message: " + ahoj.getId() + ", " + ahoj.getMessage());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Message> getMessages() {
        EntityManager readEntityManager = EntityManagerProvider.create();
        try {
            return readEntityManager.createQuery("select m from Message m").getResultList();
        } finally {
            readEntityManager.close();
        }
    }
}
