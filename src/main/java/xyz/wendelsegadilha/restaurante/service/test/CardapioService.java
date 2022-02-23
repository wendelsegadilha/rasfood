package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.CardapioDao;
import xyz.wendelsegadilha.restaurante.dao.CategoriaDao;
import xyz.wendelsegadilha.restaurante.entity.Cardapio;
import xyz.wendelsegadilha.restaurante.entity.Categoria;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    public static Categoria cadastrarCategoria(EntityManager entityManager){
        Categoria lanche = new Categoria("Lanche");
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(lanche);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return lanche;
    }

    public static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio lasanha = new Cardapio();
        lasanha.setNome("Lasanha de Carne");
        lasanha.setDescricao("Lasanha de carne com molho especial");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(12.56));
        lasanha.setCategoria(categoria);

        Cardapio macarronada = new Cardapio();
        macarronada.setNome("Macarronada de frango");
        macarronada.setDescricao("Macarronada de frango com queijo e molho picante");
        macarronada.setDisponivel(true);
        macarronada.setValor(BigDecimal.valueOf(15.90));
        macarronada.setCategoria(categoria);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(lasanha);
        entityManager.flush();
        cardapioDao.cadastrar(macarronada);
        entityManager.flush();

        System.out.println("Prato consultado: " + cardapioDao.consultar(1));
        System.out.println("Prato consultado: " + cardapioDao.consultar(2));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
