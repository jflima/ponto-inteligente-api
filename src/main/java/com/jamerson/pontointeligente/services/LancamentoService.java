package com.jamerson.pontointeligente.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.jamerson.pontointeligente.entities.Lancamento;

public interface LancamentoService {

	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	Optional<Lancamento> buscarPorId(Long lancamentoId);
	
	Lancamento persistir(Lancamento lancamento);
	
	void remover(Long id);
}
