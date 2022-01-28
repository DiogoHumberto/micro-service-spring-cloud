package br.com.interplacecom.fornecedor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.interplacecom.fornecedor.domain.InfoFornecedor;
import br.com.interplacecom.fornecedor.domain.enumerators.Booleano;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedor, Long> {
	
	InfoFornecedor findByEstado(String estado);
	
	Optional<InfoFornecedor> findByCnpjAndStatus(String cnpj, Booleano status);

}
