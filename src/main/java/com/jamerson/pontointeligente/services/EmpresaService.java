package com.jamerson.pontointeligente.services;

import java.util.Optional;

import com.jamerson.pontointeligente.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	Empresa persistir(Empresa empresa);
}
