package xyz.wendelsegadilha.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RASFOOD = Persistence.createEntityManagerFactory("rasfood");

    public static EntityManager getEntityManager(){
        return RASFOOD.createEntityManager();
    }
}
