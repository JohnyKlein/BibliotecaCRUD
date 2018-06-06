package br.org.catolicasc.sharelib.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@OneToOne
	private Cliente cliente;
	@NotNull
	@OneToOne
	private Funcionario funcionario;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	
	public Pedido() {}
	
	public Pedido(Long id, Cliente cliente, Funcionario funcionario, Date dataPedido) {
		setId(id);
		setCliente(cliente);
		setFuncionario(funcionario);
		setDataPedido(dataPedido);
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id; 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
}
