package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Integer> {
	
	//Queries personalizadas
	 @Query("SELECT u.descricao FROM Uf u WHERE u.regiao = (:regiao)")
	 public List<String> findUfByRegiao(@Param("regiao") String regiao);

}
