package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import aulajpa.Aluno;
import aulajpa.Modelo;

public class Program {

	public static void main(String[] args) throws ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulajpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		Modelo a1 = new Modelo(null, "Dory", "Masculino", df.parse("31-03-1976"));
		Modelo a2 = new Modelo(null, "Caroline", "Feminino", df.parse("24-04-1978"));
		Modelo a3 = new Modelo(null, "Isabelle", "Feminino", df.parse("21-10-2010"));
		Modelo a4 = new Modelo(null, "Ana Laura", "Feminino", df.parse("15-12-2000"));

		Modelo c1 = new Modelo(null, "Programação Orientada a Objeto I");
		Modelo c2 = new Modelo(null, "Banco de dados I");
		Modelo c3 = new Modelo(null, "Esrutura de dados I");
		
		c1.addModelo(a1);
		c1.addModelo(a2);
		
		c2.addModelo(a3);
		c2.addModelo(a4);
		
		c3.addModelo(a1);
		c3.addModelo(a4);

		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		em.getTransaction().commit();
		
		Query query1 = em.createQuery("SELECT c FROM Modelo c");
		List<Modelo> modelos = query1.getResultList();
		for (Modelo c : modelos) {
			System.out.println("\n*** " + c.getAnoModelo() + " ***");
			for (Modelo a : c.getAnoModelo())
				System.out.println("Modelo: " + a.getAnoModelo());
		}
		
		Query query2 = em.createQuery("SELECT a FROM Modelo a");
		List<Modelo> modelos = query2.getResultList();
		for (Modelo a : modelos) {
			System.out.println("\n*** " + a.getNome() + " ***");
			for (Modelo c : a.getAnoModelo())
				System.out.println("Modelo: " + c.getModelo_id());
		}
		
		Modelo c = em.find(Modelo.class, 2);
		System.out.println("\n*** Curso: " + c.getModelo_id() 
						   + " | " + c.getMarca_id() + " ***");
		for (Aluno a : c.getAnoModelo())
			System.out.println("Nome: " + a.getNome());
		
		em.close();
		emf.close();
	}
}
