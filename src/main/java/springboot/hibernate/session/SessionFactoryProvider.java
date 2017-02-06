package springboot.hibernate.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.H2Dialect;

public class SessionFactoryProvider {

    public static SessionFactory create() {
        return new Configuration().configure().buildSessionFactory();
    }
}
