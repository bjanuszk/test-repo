package springboot.hibernate.dto;

public class MostDifficultRouteDTO {

    private String climberName;
    private String routeDifficulty;

    public MostDifficultRouteDTO(final String climberName, final String routeDifficulty) {
        this.climberName = climberName;
        this.routeDifficulty = routeDifficulty;
    }

    public String getClimberName() {
        return climberName;
    }

    public String getRouteDifficulty() {
        return routeDifficulty;
    }

    @Override
    public String toString() {
        return "{" + "climberName='" + climberName + '\'' + ", routeDifficulty='" +
                routeDifficulty + '\'' + '}';
    }
}
