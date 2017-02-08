package springboot.hibernate.restapi;

import static java.lang.String.format;
import static java.lang.System.out;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hibernate.entity.Message;
import springboot.hibernate.service.MessageService;
import springboot.hibernate.session.SessionFactoryProvider;

import java.util.List;

@RestController
public class H2DbController {

    @Autowired private MessageService messageService;

    @RequestMapping("/h2jpa")
    public String h2jpa() {
        messageService.saveMessage(new Message("aaaahoj"));

        List<Message> messages = messageService.getMessages();
        messages.stream().forEach(msg -> out.println("id: " + msg.getId() + " msg: " + msg.getMessage()));
        return format("Read %s messages.", messages.size());
    }

    @RequestMapping("/h2hibernate")
    public String h2hibernate() {

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
            out.println("id: " + message.getId() + " msg: " + message.getMessage());
        }
        readSession.getTransaction().commit();
        readSession.close();

        return format("Read %s messages.", list.size());
    }
}