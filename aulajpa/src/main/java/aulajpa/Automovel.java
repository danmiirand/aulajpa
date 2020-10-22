package aulajpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Automovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	
	private Integer anoFabricacao;
	private Integer anoModelo;
	private Float   preco;
	private Integer kilometragem;	
	private Integer modelo_id;
	
	@ManyToMany(mappedBy = "modelo")                               
	private List<Modelo> modelos = new ArrayList<>();
	
	public List<Modelo> anoModelo() {
		return modelos;
	} 
	
	public void addAutomovel(Modelo c) {
		this.modelos.add(c);
		c.getModelos().addAll((Collection<? extends Modelo>) this);
	}

	public void removeCurso(Modelo c) {
		this.modelos.remove(c);
		c.getModelos().remove(this);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFsbricacao) {
		this.anoFabricacao = anoFsbricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Integer kilometragem) {
		this.kilometragem = kilometragem;
	}

	public Integer getModelo_id() {
		return modelo_id;
	}

	public void setModelo_id(Integer modelo_id) {
		this.modelo_id = modelo_id;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result + ((anoModelo == null) ? 0 : anoModelo.hashCode());
		result = prime * result + ((modelos == null) ? 0 : modelos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kilometragem == null) ? 0 : kilometragem.hashCode());
		result = prime * result + ((modelo_id == null) ? 0 : modelo_id.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Automovel other = (Automovel) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (anoModelo == null) {
			if (other.anoModelo != null)
				return false;
		} else if (!anoModelo.equals(other.anoModelo))
			return false;
		if (modelos == null) {
			if (other.modelos != null)
				return false;
		} else if (!modelos.equals(other.modelos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kilometragem == null) {
			if (other.kilometragem != null)
				return false;
		} else if (!kilometragem.equals(other.kilometragem))
			return false;
		if (modelo_id == null) {
			if (other.modelo_id != null)
				return false;
		} else if (!modelo_id.equals(other.modelo_id))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Automovel [id=" + id + ", anoFsbricacao=" + anoFabricacao + ", anoModelo=" + anoModelo + ", preco="
				+ preco + ", kilometragem=" + kilometragem + ", modelo_id=" + modelo_id + "]";
	}
	
	
}
