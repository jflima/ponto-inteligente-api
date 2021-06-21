package com.jamerson.pontointeligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jamerson.pontointeligente.entities.Lancamento;
import com.jamerson.pontointeligente.repositories.LancamentoRepository;
import com.jamerson.pontointeligente.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lancamento pelo id do funcionario {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long lancamentoId) {
		log.info("Buscando lancamento pelo id {}", lancamentoId);
		return this.lancamentoRepository.findById(lancamentoId);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo lancamento {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo lancamento com id {}", id);
		this.lancamentoRepository.deleteById(id);
	}

}
