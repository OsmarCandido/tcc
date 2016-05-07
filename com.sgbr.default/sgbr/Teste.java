package sgbr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String args[]) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgbr");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		trx.commit();
	}
}
