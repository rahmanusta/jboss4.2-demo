package com.kodcu.war;

import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("kodcuService")
@SessionScoped
public class KodcuService implements Serializable {

    @Inject
    private Session session;

    private List<Hedgehog> users;

    public String getHello() {
        return "Your KodcuService says hi!";
    }

    @PostConstruct
    public void loadHedgehogs() {
        users = session.createCriteria(Hedgehog.class).list();
    }

    @Produces
    @Named("users")
    public List<Hedgehog> getUsers() {
        return users;
    }

    public void setUsers(List<Hedgehog> users) {
        this.users = users;
    }
}
