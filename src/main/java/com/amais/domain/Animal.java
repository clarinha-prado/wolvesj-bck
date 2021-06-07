package com.amais.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "animais")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nm_animal;
	private Date dt_provavel_nasc;
	private Date dt_acolhimento;
	private Short especie;
	private String raca;
	private Short sexo;
	private String pelagem;
	private Short porte;
	private String caracteristicas;
	private Short castrado;
	private String historia;
	private String localizacao;
	private Short situacao;
	private String apelidos;
	
	public Animal() {};
	
	public Animal(Integer id, String nm_animal, Date dt_provavel_nasc, Date dt_acolhimento, Short especie, String raca,
			Short sexo, String pelagem, Short porte, String caracteristicas, Short castrado, String historia,
			String localizacao, short situacao, String apelidos) {
		super();
		this.id = id;
		this.nm_animal = nm_animal;
		this.dt_provavel_nasc = dt_provavel_nasc;
		this.dt_acolhimento = dt_acolhimento;
		this.especie = especie;
		this.raca = raca;
		this.sexo = sexo;
		this.pelagem = pelagem;
		this.porte = porte;
		this.caracteristicas = caracteristicas;
		this.castrado = castrado;
		this.historia = historia;
		this.localizacao = localizacao;
		this.situacao = situacao;
		this.apelidos = apelidos;
	}
	public String getNm_animal() {
		return nm_animal;
	}
	public void setNm_animal(String nm_animal) {
		this.nm_animal = nm_animal;
	}
	public Date getDt_provavel_nasc() {
		return dt_provavel_nasc;
	}
	public void setDt_provavel_nasc(Date dt_provavel_nasc) {
		this.dt_provavel_nasc = dt_provavel_nasc;
	}
	public Date getDt_acolhimento() {
		return dt_acolhimento;
	}
	public void setDt_acolhimento(Date dt_acolhimento) {
		this.dt_acolhimento = dt_acolhimento;
	}
	public Short getEspecie() {
		return especie;
	}
	public void setEspecie(Short especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Short getSexo() {
		return sexo;
	}
	public void setSexo(Short sexo) {
		this.sexo = sexo;
	}
	public String getPelagem() {
		return pelagem;
	}
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
	public Short getPorte() {
		return porte;
	}
	public void setPorte(Short porte) {
		this.porte = porte;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public Short getCastrado() {
		return castrado;
	}
	public void setCastrado(Short castrado) {
		this.castrado = castrado;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Short getSituacao() {
		return situacao;
	}
	public void setSituacao(Short situacao) {
		this.situacao = situacao;
	}
	public String getApelidos() {
		return apelidos;
	}
	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
