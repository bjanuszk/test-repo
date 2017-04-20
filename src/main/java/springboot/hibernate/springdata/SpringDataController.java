package springboot.hibernate.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.hibernate.entity.Climber;

@RestController
public class SpringDataController {

    @Autowired
    private ClimberRepository climberRepository;

    @RequestMapping("/findClimberByName/{name}")
    public Climber findByName(@PathVariable String name){

        System.out.println("Finding climber by name: " + name);
        return  climberRepository.findByName(name);
    }
}
