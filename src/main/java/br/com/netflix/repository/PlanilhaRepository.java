package br.com.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netflix.model.Planilha;

public interface PlanilhaRepository extends JpaRepository<Planilha, Long>{

}
