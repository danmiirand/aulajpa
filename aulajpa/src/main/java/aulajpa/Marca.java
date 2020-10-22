package aulajpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Marca implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String  nome;
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Nome> getNome() {
		return nomes;
	}

	public void setNomes(List<Nome> nomes) {
		this.nomes = nomes;
	}

	
	@OneToOne 
	@JoinTable( name="Automovel",
				joinColumns = @JoinColumn(name="modelo_id"),
				inverseJoinColumns = @JoinColumn(name="marca_id"))
	private List<nome> nomes = new ArrayList<>();
	
	public List<Nome> getNomo() {
		return nomes;
	}

	public void addNome(Nome a) {
		this.nomes.add(a);
		a.getNomes().add(this);
	}

	public void removeNome(Nome a) {
		this.nomes.remove(a);
		a.getNomes().remove(this);
	}