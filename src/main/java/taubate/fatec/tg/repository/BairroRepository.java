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
	 * Exemplo
	 * 
	 * @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.login= (:login)")
	 * public Usuario findByLogin(@Param("login") String login);
	 * 
	 * boolean existsByUsername(String login);
	 */
	
	 @Query("SELECT b.descricao FROM Bairro b WHERE b.regiao= (:regiao)")
	 public List<String> findBairroByRegiao(@Param("regiao") String regiao);

}
