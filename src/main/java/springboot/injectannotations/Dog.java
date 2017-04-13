package springboot.injectannotations;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void makeNoise() {
        System.out.println("DOG: hau hau");
    }

    @EventListener
    void handle(AnimalEvent event) {
        System.out.println("############ EVENT RECEIVED ############ " + event.getContent());
    }
}
