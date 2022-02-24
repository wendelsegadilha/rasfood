package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Cardapio;
import xyz.wendelsegadilha.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria consultarPorId(Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos() {
        String sql = "SELECT c FROM Categoria c";
        return entityManager.createQuery(sql, Categoria.class).getResultList();
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
