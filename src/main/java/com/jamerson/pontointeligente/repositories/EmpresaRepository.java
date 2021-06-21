package com.jamerson.pontointeligente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jamerson.pontointeligente.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
}
