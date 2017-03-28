package springboot.hibernate.restapi;

import static java.lang.String.format;
import static java.lang.System.out;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hibernate.dto.MostDifficultRouteDTO;
import springboot.hibernate.entity.Climber;
import springboot.hibernate.entity.Message;
import springboot.hibernate.entity.Nickname;
import springboot.hibernate.entity.Route;
import springboot.hibernate.entity.SportRoute;
import springboot.hibernate.entity.TradRoute;
import springboot.hibernate.service.RepositoryService;
import springboot.hibernate.session.SessionFactoryProvider;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

@RestController
public class H2DbController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/h2jpa")
    public String h2jpa() {
        repositoryService.save(new Message("aaaahoj"));

        List<Message> messages = repositoryService.getAll(Message.class);
        messages.stream().forEach(msg -> out.println("id: " + msg.getId() + " msg: " + msg.getMessage()));
        return format("Read %s messages.", messages.size());
    }

    @RequestMapping("/climberTest")
    public String climberTest() {
        Route znikajacyPunkt = new SportRoute("Znikajacy Punkt", "7a+", new Date());
        Route ambrozy = new SportRoute("Ambrozy", "7a", new Date());
        Route nosZubra = new SportRoute("Nos Zubra", "7b", new Date());
        Route hokej = new SportRoute("Hokej", "7a", new Date());
        Route brzytwa = new SportRoute("Brzytwa", "6c+", new Date());
        Route bumerang = new TradRoute("Bumerang", "7b", 2);

        Climber bartek = new Climber("Bartek");
        bartek.addRoutes(znikajacyPunkt, ambrozy, bumerang);
        bartek.setNickname(new Nickname("bartol"));

        Climber gosia = new Climber("Gosia");
        gosia.addRoutes(ambrozy, nosZubra, hokej, brzytwa, bumerang);

        repositoryService.save(gosia, bartek);

        List<Climber> climbers = repositoryService.getAll(Climber.class);
        climbers.stream().forEach(cl -> out.println(cl.toString()));
        return format("Read %s climbers.", climbers.size());
    }

    @RequestMapping("/routeTest")
    public String routesTest() {
        SportRoute sportRoute = new SportRoute("Krzywa", "6b", new Date());
        repositoryService.save(sportRoute);

        TradRoute tradRoute = new TradRoute("Zuzugula", "7a", 8);
        repositoryService.save(tradRoute);

        List<Route> all = repositoryService.getAll(Route.class);
        return all.toString();
    }

    @RequestMapping("/cbAllClimbers")
    public List<Climber> cbAllClimbers() {
        CriteriaBuilder cb = repositoryService.getCriteriaBuilder();
        CriteriaQuery<Climber> climberCriteriaQuery = cb.createQuery(Climber.class);
        Root<Climber> root = climberCriteriaQuery.from(Climber.class);
        CriteriaQuery<Climber> getAllClimbersQuery = climberCriteriaQuery.select(root);
        List<Climber> climbers = repositoryService.executeQuery(getAllClimbersQuery);
        System.out.println("### [cb] All climbers: " + climbers.size());
        return climbers;
    }

    @RequestMapping("/jpqlAllClimbers")
    public List<Climber> jpqlAllClimbers() {
        String allClimbers = " select c from Climber c";
        List climbers = repositoryService.executeQuery(allClimbers);
        System.out.println("### [jpql] All climbers: " + climbers.size());
        return climbers;
    }

    @RequestMapping("/cbMostDifficultRoute")
    public List<MostDifficultRouteDTO> cbMostDifficultRoute() {
        CriteriaBuilder cb = repositoryService.getCriteriaBuilder();
        CriteriaQuery<MostDifficultRouteDTO> query = cb.createQuery(MostDifficultRouteDTO.class);
        Root<Climber> climberRoot = query.from(Climber.class);
        ListJoin<Climber, Route> routes = climberRoot.joinList("routes");
        CriteriaQuery<MostDifficultRouteDTO> most = query.select(cb
                .construct(MostDifficultRouteDTO.class, climberRoot.get("name"),
                        cb.max(routes.get("difficulty")))).groupBy(climberRoot.get("name"));
        List<MostDifficultRouteDTO> mostDifficultRouteDTOS = repositoryService.executeQuery(most);
        System.out.println("### [criteria] Most difficult routes: " + mostDifficultRouteDTOS.size());
        return mostDifficultRouteDTOS;
    }

    @RequestMapping("/jpqlMostDifficultRoute")
    public List<MostDifficultRouteDTO> jpqlMostDifficultRoute() {
        String mostDifficultRoute = "SELECT NEW springboot.hibernate.dto.MostDifficultRouteDTO(c.name, MAX(route" +
                "" + ".difficulty)) FROM Climber c JOIN c.routes route GROUP BY c.name";
        List mostDifficultRoutes = repositoryService.executeQuery(mostDifficultRoute);
        System.out.println("### [jpql] Most difficult routes: " + mostDifficultRoutes.size());
        return mostDifficultRoutes;
    }

    @RequestMapping("/routeIdTest/{id}")
    public String routeIdTest(@PathVariable long id) {
        return repositoryService.findById(id, Route.class).toString();
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