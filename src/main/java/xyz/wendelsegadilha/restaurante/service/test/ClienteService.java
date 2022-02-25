package xyz.wendelsegadilha.restaurante.service.test;

import xyz.wendelsegadilha.restaurante.dao.ClienteDao;
import xyz.wendelsegadilha.restaurante.entity.Cliente;
import xyz.wendelsegadilha.restaurante.entity.Endereco;
import xyz.wendelsegadilha.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class ClienteService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Cliente wendel = new Cliente("1111111111", "Wendel" );
        Endereco endereco = new Endereco();

        endereco.setRua("Rua 01");
        endereco.setCidade("Santa Inês");
        endereco.setEstado("MA");
        endereco.setCep("65300855");
        endereco.setComplemento("Casa murada");
        wendel.addEndereco(endereco);

        ClienteDao clienteDao = new ClienteDao(entityManager);
        clienteDao.cadastrar(wendel);
        System.out.println(wendel);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
