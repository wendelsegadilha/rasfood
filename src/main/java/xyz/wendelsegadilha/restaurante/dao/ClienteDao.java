package xyz.wendelsegadilha.restaurante.dao;

import xyz.wendelsegadilha.restaurante.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class ClienteDao {

    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorId(Integer id){
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos(){
        try{
            String sql = "SELECT c FROM Cliente c";
            return this.entityManager.createQuery(sql, Cliente.class).getResultList();
        }catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(Cliente cliente){
        this.entityManager.remove(cliente);
    }

}
