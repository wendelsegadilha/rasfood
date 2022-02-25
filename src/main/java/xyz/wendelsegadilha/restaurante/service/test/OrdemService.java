package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.ClienteDao;
import xyz.wendelsegadilha.restaurante.dao.OrdemDao;
import xyz.wendelsegadilha.restaurante.entity.Ordem;
import xyz.wendelsegadilha.restaurante.util.CargaDeDadosUtil;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorNome("Lopes"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
