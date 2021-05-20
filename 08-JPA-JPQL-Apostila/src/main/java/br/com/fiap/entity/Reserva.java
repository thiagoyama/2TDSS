package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQueries({

	//Pesquisar reserva por parte do nome do cliente
	@NamedQuery(name="Reserva.PorNomeCliente", 
				query="select r from Reserva r where r.cliente.nome like :n"),
	
	//Pesquisar reserva por número de dias igual
	@NamedQuery(name="Reserva.PorNumeroDias", 
				query="select r from Reserva r where r.numeroDias = :number")
	
})

@Entity
@Table(name="TB_EAD_RESERVA")
@SequenceGenerator(name="seqReserva", sequenceName="SEQ_TB_EAD_RESERVA", allocationSize=1)
public class Reserva {

	@Id
	@Column(name="cd_reserva")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqReserva")
	private int id;
	
	@Column(name="nr_dias")
	private Integer numeroDias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_reserva")
	private Calendar dataReserva;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_pacote")
	private Pacote pacote;
	
	@ManyToOne
	@JoinColumn(name="cd_cliente")
	private Cliente cliente;
	
	public Reserva(Integer numeroDias, Calendar dataReserva, Pacote pacote, Cliente cliente) {
		super();
		this.numeroDias = numeroDias;
		this.dataReserva = dataReserva;
		this.pacote = pacote;
		this.cliente = cliente;
	}

	public Reserva() {
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getId() {
		return id;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
