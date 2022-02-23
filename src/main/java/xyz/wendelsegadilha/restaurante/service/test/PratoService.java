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

        Prato macarronada = new Prato();
        macarronada.setNome("Macarronada de frango");
        macarronada.setDescricao("Macarronada de frango com queijo e molho picante");
        macarronada.setDisponivel(true);
        macarronada.setValor(BigDecimal.valueOf(15.90));

        EntityManager entityManager = JPAUtil.getEntityManager();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();

        pratoDao.cadastrar(lasanha);
        entityManager.flush();

        pratoDao.cadastrar(macarronada);
        entityManager.flush();
        System.out.println("Prato consultado: " + pratoDao.consultar(2));

        pratoDao.excluir(macarronada);
        System.out.println("Prato consultado: " + pratoDao.consultar(2));

        entityManager.clear();
        lasanha.setValor(BigDecimal.valueOf(12.78));
        pratoDao.atualizar(lasanha);
        System.out.println("Prato consultado: " + pratoDao.consultar(1));
    }

}
