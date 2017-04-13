package springboot.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name="getRoutesOfClimber",query = "SELECT c.routes FROM Climber c WHERE c.climberId = ?0")
public class Climber {

    @Id
    @SequenceGenerator(name = "climber_id_sequence", sequenceName = "climber_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "climber_id_sequence")
    private Long climberId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "CLIMBERS_ROUTES", joinColumns = {@JoinColumn(name = "climberId")},
            inverseJoinColumns = {@JoinColumn(name = "routeId")})
    private List<Route> routes = new ArrayList<>();

    @Embedded
    private Nickname nickname;

    Climber() {
    }

    public Climber(String name) {
        this.name = name;
    }

    public Long getClimberId() {
        return climberId;
    }

    public String getName() {
        return name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void addRoutes(Route... route) {
        for (Route r : route) {
            this.routes.add(r);
        }
    }

    public Nickname getNickname() {
        return nickname;
    }

    public void setNickname(final Nickname nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Climber{" + "climberId=" + climberId + ", name='" + name + '\'' + ", routes=" + routes + '}';
    }
}
