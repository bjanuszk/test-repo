package springboot.hibernate.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboot.hibernate.entity.Route;
import springboot.hibernate.entity.SportRoute;

import java.util.Date;

@Component
@Transactional
public class TransactionComposer {

    @Autowired
    private Service service;

    @Autowired
    private GenericDAO genericDAO;

    public void test() {

        Route miniMax = new SportRoute("Minimax3", "7b+", new Date());
        service.save(miniMax);

        service.throwException();
    }
}
