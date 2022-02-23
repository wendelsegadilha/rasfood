package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.CardapioDao;
import xyz.wendelsegadilha.restaurante.entity.Cardapio;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        Cardapio lasanha = new Cardapio();
        lasanha.setNome("Lasanha de Carne");
        lasanha.setDescricao("Lasanha de carne com molho especial");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(12.56));

        Cardapio macarronada = new Cardapio();
        macarronada.setNome("Macarronada de frango");
        macarronada.setDescricao("Macarronada de frango com queijo e molho picante");
        macarronada.setDisponivel(true);
        macarronada.setValor(BigDecimal.valueOf(15.90));

        EntityManager entityManager = JPAUtil.getEntityManager();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(lasanha);
        entityManager.flush();

        cardapioDao.cadastrar(macarronada);
        entityManager.flush();
        System.out.println("Prato consultado: " + cardapioDao.consultar(2));

        cardapioDao.excluir(macarronada);
        System.out.println("Prato consultado: " + cardapioDao.consultar(2));

        entityManager.clear();
        lasanha.setValor(BigDecimal.valueOf(12.78));
        cardapioDao.atualizar(lasanha);
        System.out.println("Prato consultado: " + cardapioDao.consultar(1));
    }

}
