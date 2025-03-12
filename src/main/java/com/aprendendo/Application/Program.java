package com.aprendendo.Application;

import com.aprendendo.Dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");//Cria gerenciadores de entidades e mantém as configurações da conexão.
        EntityManager em = emf.createEntityManager();//Realiza operações no banco de dados, como inserir, atualizar e remover entidades.

        Pessoa p = new Pessoa(null,"Carlos da Silva", "carlos@gmail.com");
        Pessoa p1 = new Pessoa(null,"Ana Clara", "ana@gmail.com");
        Pessoa p2 = new Pessoa(null,"Josefa Silva", "josefa@gmail.com");

        em.getTransaction().begin();
        em.persist(p);
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();

        System.out.println("Done!");

        Pessoa p3= em.find(Pessoa.class, 1);
        System.out.println(p3);


        em.getTransaction().begin();
        em.remove(p3);
        em.getTransaction().commit();
        emf.close();
        em.close();

    }
}