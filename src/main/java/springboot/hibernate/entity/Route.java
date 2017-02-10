package springboot.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Route {

    @Id
    @SequenceGenerator(name = "route_id_sequence", sequenceName = "route_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_id_sequence")
    private Long routeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String difficulty;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "routes")
    private Set<Climber> climbers;


    Route() {
    }

    public Route(final String name, final String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public Long getRouteId() {
        return routeId;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "Route{" + "routeId=" + routeId + ", name='" + name + '\'' + ", difficulty='" + difficulty + '\'' + '}';
    }
}
