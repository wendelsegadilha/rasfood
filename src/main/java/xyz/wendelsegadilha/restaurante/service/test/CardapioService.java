package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.CardapioDao;
import xyz.wendelsegadilha.restaurante.util.CargaDeDadosUtil;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("O produto pesquisado foi: " + cardapioDao.consultarPorNome("moqueca"));
        entityManager.close();
    }

}
