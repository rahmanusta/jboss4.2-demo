package com.kodcu.war;

import javax.ejb.Remove;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.ScopeType;
import org.hibernate.Session;

import java.util.List;
import java.io.Serializable;

@Name("kodcuService")
@Scope(ScopeType.SESSION)
public class KodcuService implements Serializable {

    @In(create = true)
    private Session session;

    @DataModel
    private List<Hedgehog> users;

    public KodcuService() {
    }

    public String getHello() {
        return "Your KodcuService says hi!";
    }

    @Factory("users")
    public void loadHedgehogs() {
        users = session.createCriteria(Hedgehog.class).list();
    }

    @Remove
    public void destroy() {}
}
