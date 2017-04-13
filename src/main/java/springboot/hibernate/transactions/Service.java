package springboot.hibernate.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Service {

    @Autowired
    private GenericDAO genericDAO;

    public Object save(Object objToSave) {
        return genericDAO.save(objToSave);
    }

    public Object findById(long id, Class clazz) {
        return genericDAO.findById(id, clazz);
    }

    public void throwException() {
        throw new MyTransactionException("Exception thrown intentionally");
    }
}
