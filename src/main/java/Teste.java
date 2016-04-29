
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
		funcionario.setNome("Osmar Candidom Ribeiro Junior");
		funcionario.setTelefone("(99)9999-9999");
		funcionario.setCpf ("115.967.207-51");
		funcionario.setLogin("Vinicius");
		funcionario.setSenha("1234567");
		funcionario.setPerfil(Perfil.GARCOM);
		
		
		manager.persist(funcionario);
		
		trx.commit();
		
	}	
}



