package br.com.netflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.netflix.model.Planilha;
import br.com.netflix.model.Usuario;

public interface PlanilhaRepository extends JpaRepository<Planilha, Long>{
	//select periodo_id, usuario_id, situacao from planilha where periodo_id = :p && usuario_id = :user;
	@Query("select p from Planilha p where periodo_id = :periodo and usuario_id = :user")
	List<Planilha> findByUsuarioSituacao(@Param("periodo") int periodo, @Param("user") long user);

}
