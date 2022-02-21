package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.PratoDao;
import xyz.wendelsegadilha.restaurante.entity.Prato;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {
        Prato lasanha = new Prato();
        lasanha.setNome("Lasanha de Carne");
        lasanha.setDescricao("Lasanha de carne com molho especial");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(12.56));

        EntityManager entityManager = JPAUtil.getEntityManager();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(lasanha);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
