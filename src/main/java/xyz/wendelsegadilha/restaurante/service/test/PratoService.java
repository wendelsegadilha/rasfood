package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {
        Prato lasanha = new Prato();
        lasanha.setNome("Lasanha de Carne");
        lasanha.setDescricao("Lasanha de carne com molho especial");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(12.56));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasfood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(lasanha);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
