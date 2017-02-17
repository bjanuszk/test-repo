package springboot.hibernate.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("sport")
public class SportRoute extends Route {

    private Date firstAscent;

    SportRoute() {
    }

    public SportRoute(final String name, final String difficulty, Date firstAscent) {
        this.name = name;
        this.difficulty = difficulty;
        this.firstAscent = firstAscent;
    }

    public Date getFirstAscent() {
        return firstAscent;
    }

    @Override
    public String toString() {
        return "SportRoute{" + "firstAscent=" + firstAscent + "} " + super.toString();
    }
}
