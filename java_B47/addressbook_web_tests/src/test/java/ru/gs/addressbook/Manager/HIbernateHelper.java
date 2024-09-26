package ru.gs.addressbook.Manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.schema.Action;

import javax.security.auth.login.Configuration;

public class HIbernateHelper extends HelperBase{
    public HIbernateHelper(ApplicationManager manager)
    { super(manager);

        sessionFactory = new Configuration()

                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/addressbook")
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "password")

                .buildSessionFactory();

    }
}
