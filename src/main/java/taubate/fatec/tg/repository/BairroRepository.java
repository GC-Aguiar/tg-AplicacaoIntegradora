package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Bairro;

@Repository
public interface BairroRepository extends JpaRepository <Bairro, Integer> {
	
	/*
	 	@Modifying
		@Query("UPDATE Bairro b set b.firstname = ?1, b.lastname = ?2 where b.codigo = ?3")
		void setBairroById(String firstname, String lastname, Integer userId);
	 */
	
	 @Query("SELECT b.descricao FROM Bairro b WHERE b.regiao= (:regiao)")
	 public List<String> findBairroByRegiao(@Param("regiao") String regiao);

}
