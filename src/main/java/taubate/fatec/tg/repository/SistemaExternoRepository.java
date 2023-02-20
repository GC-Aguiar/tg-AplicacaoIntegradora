package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.SistemaExterno;

@Repository
public interface SistemaExternoRepository extends JpaRepository<SistemaExterno, Integer>{
	
	//Queries personalizadas
	 @Query("SELECT s.descricao FROM SistemaExterno s WHERE s.status = (:status)")
	 public List<String> findSistemaExternoByStatus(@Param("status") String status);
	

}
