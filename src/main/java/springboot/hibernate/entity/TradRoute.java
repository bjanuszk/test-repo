package springboot.hibernate.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("trad")
public class TradRoute extends Route {

    private int numberOfPitches;

    TradRoute() {
    }

    public TradRoute(final String name, final String difficulty, final int numberOfPitches) {
        this.name = name;
        this.difficulty = difficulty;
        this.numberOfPitches = numberOfPitches;
    }


    public int getNumberOfPitches() {
        return numberOfPitches;
    }

    @Override
    public String toString() {
        return "TradRoute{" + "numberOfPitches=" + numberOfPitches + "} " + super.toString();
    }
}
