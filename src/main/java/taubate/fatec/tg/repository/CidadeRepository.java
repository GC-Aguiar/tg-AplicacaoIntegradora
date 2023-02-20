package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade, Integer>{
	
	//Queries personalizadas
	 @Query("SELECT c.descricao FROM Cidade c WHERE c.ufCodigo= (:ufCodigo)")
	 public List<String> findCidadeByUf(@Param("ufCodigo") Integer ufCodigo);
}
