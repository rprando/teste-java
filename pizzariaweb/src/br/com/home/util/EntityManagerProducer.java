package br.com.home.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	@Produces @ApplicationScoped
	public EntityManagerFactory criateFactory(){
		return Persistence.createEntityManagerFactory("pw");
	}
	
	@Produces @RequestScoped
	public EntityManager created(EntityManagerFactory factory) throws Exception{
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager) throws Exception{
		manager.close();
	}
}
