package springboot.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Nickname {

    private String nick;

    public Nickname() {
    }

    public Nickname(final String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }
}
