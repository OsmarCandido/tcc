
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.sgbr.model.Mesa;
import com.sgbr.model.Status;



public class Teste {
  
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgbr");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Mesa mesa = new Mesa();
		
		mesa.setNome("mesa01");
		mesa.setStatus(Status.ABERTO);
				
				
		manager.persist(mesa);
		
		trx.commit();
		
	}	
}