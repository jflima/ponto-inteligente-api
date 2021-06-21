package com.jamerson.pontointeligente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jamerson.pontointeligente.enums.PerfilEnum;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9008785708914961604L;
	
	private long id;
	private String name;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empresa;
	private List<Lancamento> lancamentos;
	
	public Funcionario() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "valor_hora", nullable = true)
	public BigDecimal getValorHora() {
		return valorHora;
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	@Column(name = "qtd_horas_trabalhadas_dia", nullable = true)
	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	@Column(name = "qtd_horas_almoco", nullable = true)
	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	@Transient
	public Optional<Float> getQtdHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmoco);
	}
	
	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", name=" + name + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", empresa=" + empresa + ", lancamentos=" + lancamentos + "]";
	}
}
