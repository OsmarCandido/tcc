
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.sgbr.model.Funcionario;
import com.sgbr.model.Perfil;


public class Teste {
  
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgbr");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Osmar Candido Ribeiro Junior");
		funcionario.setTelefone("21 998287195");
		funcionario.setCpf ("11596720751");
		funcionario.setPerfil(Perfil.GARCOM);
		
		
		manager.persist(funcionario);
		
		trx.commit();
		
	}	
}



