package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Cardapio;
import xyz.wendelsegadilha.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
