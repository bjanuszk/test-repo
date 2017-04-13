package springboot.injectannotations;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class Cat implements Animal {

    @Inject
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void makeNoise() {
        System.out.println("CAT: miau miau");
    }

    public void publishEvent(String eventContent) {
        applicationEventPublisher.publishEvent(new AnimalEvent(eventContent));
    }
}
