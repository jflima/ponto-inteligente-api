package com.jamerson.pontointeligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamerson.pontointeligente.entities.Empresa;
import com.jamerson.pontointeligente.repositories.EmpresaRepository;
import com.jamerson.pontointeligente.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa por CNPJ: {}");
		return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}
