package springboot.hibernate.springdata;

import org.springframework.data.repository.CrudRepository;
import springboot.hibernate.entity.Climber;

public interface ClimberRepository extends CrudRepository<Climber, Integer> {

    Climber findByName(String name);
}
