package springboot.hibernate.restapi;

import springboot.hibernate.entity.Message;
import springboot.hibernate.session.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class H2DbController {

    @RequestMapping("/h2test")
    public String h2test() {

        SessionFactory sessionFactory = SessionFactoryProvider.create();
        Session writeSession = sessionFactory.openSession();

        writeSession.beginTransaction();
        writeSession.save(new Message("ahoj"));
        writeSession.getTransaction().commit();
        writeSession.close();

        Session readSession = sessionFactory.openSession();
        readSession.beginTransaction();
        List<Message> list = readSession.createQuery("from Message").list();
        for (Message message : list) {
            System.out.println("id: " + message.getId() + " msg: " + message.getMessage());
        }
        readSession.getTransaction().commit();
        readSession.close();

        return String.format("Read %s messages.", list.size());
    }
}