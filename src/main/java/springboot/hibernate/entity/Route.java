package springboot.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Route {

    @Id
    @SequenceGenerator(name = "route_id_sequence", sequenceName = "route_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_id_sequence")
    protected Long routeId;

    @Column
    protected String name;

    protected String difficulty;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "routes")
    protected Set<Climber> climbers;

    public Long getRouteId() {
        return routeId;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Set<Climber> getClimbers() {
        return climbers;
    }

    @Override
    public String toString() {
        return "Route{" + "routeId=" + routeId + ", name='" + name + '\'' + ", difficulty='" + difficulty + '\'' + "," +
                "" + '}';
    }
}
