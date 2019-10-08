package br.com.listavip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="vquantitativos_Toyota", schema = "dbo")
public class Requests {
	
	@Id
	@Column(name="Codigo")
	private String Codigo;
	
	@Column(name="Data")
	private Date Data;
	
	@Column (name="\"ULTIMO ANALISTA PARA\"")
	private String ultimo_analista;
	
	@Column (name="Aberto")
	private String Aberto;
	
	@Column(name="Assunto")
	private String Assunto;
	
	@Column(name="Prioridade")
	private String Prioridade;
	
	@Column(name="Estado")
	private String Estado;
	
	@Transient
	private String HoraCalc;
	
	public String getEstado() {
		return Estado;
	}
	public String getPrioridade() {
		return Prioridade;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getAberto() {
		return Aberto;
	}
	public String getUltimo_analista() {
		if (ultimo_analista.equals("FILA N2 - AppSupport - Commercial")){
			ultimo_analista = "Commercial";
		} else if (ultimo_analista.equals("FILA N2 - AppSupport - ADM/HR/Finance")) {
			ultimo_analista = "ADM/HR/Finance";
		}
		return ultimo_analista;
	}
	public Date getData() {
		return Data;
	}
	public String getAssunto() {
		return Assunto;
	}
	public String getHoraCalc() {
		return HoraCalc;
	}
	public void setHoraCalc(String horaCalc) {
		HoraCalc = horaCalc;
	}
	
}
