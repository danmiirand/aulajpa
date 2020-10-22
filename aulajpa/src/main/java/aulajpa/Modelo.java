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
public class Modelo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer modelo_id;
	
	public Modelo(Integer modelo_id, String descricao) {
		super();
		this.modelo_id = modelo_id;
		this.descricao = descricao;
	}


	@Column (name = "descricao", nullable = false)
	private String descricao;
	
	public Integer getModelo_id() {
		return modelo_id;
	}

	public void setModelo_id(Integer modelo_id) {
		this.modelo_id = modelo_id;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	
	@OneToOne 
	@JoinTable( name="aluno_",
				joinColumns = @JoinColumn(name="idcurso"),
				inverseJoinColumns = @JoinColumn(name="idaluno"))
	private List<Modelo> modelos = new ArrayList<>();
	
	public List<Modelo> getAnoModelo() {
		return modelos;
	}

	public void addModelo(Modelo a) {
		this.modelos.add(a);
		a.getAnoModelo().add(this);
	}

	public void removeMarca(Modelo a) {
		this.modelos.remove(a);
		a.getAnoModelo().remove(this);
	}

	public Modelo() {

	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelo_id== null) ? 0 : modelo_id.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (modelo_id == null) {
			if (other.modelo_id != null)
				return false;
		} else if (!modelo_id.equals(other.modelo_id))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + modelo_id + ", nomecurso=" + descricao + "]";
	}
	
	
}
