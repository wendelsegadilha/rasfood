package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.CardapioDao;
import xyz.wendelsegadilha.restaurante.dao.ClienteDao;
import xyz.wendelsegadilha.restaurante.dao.OrdemDao;
import xyz.wendelsegadilha.restaurante.entity.Cliente;
import xyz.wendelsegadilha.restaurante.entity.Ordem;
import xyz.wendelsegadilha.restaurante.entity.OrdensCardapio;
import xyz.wendelsegadilha.restaurante.util.CargaDeDadosUtil;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Cliente wendel = new Cliente("111111111111", "Wendel");
        Ordem ordem = new Ordem(wendel);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1), 2));

        clienteDao.cadastrar(wendel);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
