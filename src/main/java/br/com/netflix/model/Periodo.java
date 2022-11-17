package br.com.netflix.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int mes;
	private double valorPorUsuario;
	private double valorMensal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public double getValorPorUsuario() {
		return valorPorUsuario;
	}
	public void setValorPorUsuario(double valorPorUsuario) {
		this.valorPorUsuario = valorPorUsuario;
	}
	public double getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodo other = (Periodo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
