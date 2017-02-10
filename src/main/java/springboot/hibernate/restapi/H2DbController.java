package springboot.hibernate.restapi;

import static java.lang.String.format;
import static java.lang.System.out;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hibernate.entity.Climber;
import springboot.hibernate.entity.Message;
import springboot.hibernate.entity.Route;
import springboot.hibernate.service.RepositoryService;
import springboot.hibernate.session.SessionFactoryProvider;

import java.util.List;

@RestController
public class H2DbController {

    @Autowired private RepositoryService repositoryService;

    @RequestMapping("/h2jpa")
    public String h2jpa() {
        repositoryService.save(new Message("aaaahoj"));

        List<Message> messages = repositoryService.getAll(Message.class);
        messages.stream().forEach(msg -> out.println("id: " + msg.getId() + " msg: " + msg.getMessage()));
        return format("Read %s messages.", messages.size());
    }

    @RequestMapping("/climberTest")
    public String climberTest() {
        Route znikajacyPunkt = new Route("Znikajacy Punkt", "7a+");
        Route ambrozy = new Route("Ambrozy", "7a");
        Route nosZubra = new Route("Nos Zubra", "7b");
        Route hokej = new Route("Hokej", "7a");
        Route brzytwa = new Route("Brzytwa", "6c+");

        Climber bartek = new Climber("Bartek");
        bartek.addRoutes(znikajacyPunkt, ambrozy);
        repositoryService.save(bartek);

        Climber gosia = new Climber("Gosia");
        gosia.addRoutes(ambrozy, nosZubra, hokej, brzytwa);
        repositoryService.save(gosia);

        List<Climber> climbers = repositoryService.getAll(Climber.class);
        climbers.stream().forEach(cl -> out.println(cl.toString()));
        return format("Read %s climbers.", climbers.size());
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