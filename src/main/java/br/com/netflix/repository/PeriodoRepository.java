package br.com.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netflix.model.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Long>{

}
