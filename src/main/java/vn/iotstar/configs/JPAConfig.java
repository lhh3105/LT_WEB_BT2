package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
	public static EntityManager getEntityManager() {


		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");


		 return factory.createEntityManager();
	}
	}
