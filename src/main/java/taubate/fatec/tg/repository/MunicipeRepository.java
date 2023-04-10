package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Municipe;

@Repository
public interface MunicipeRepository extends JpaRepository<Municipe, Integer> {

	@Query("SELECT m FROM Municipe m WHERE m.cpf = (:cpf)")
	public Municipe findMunicipeByCpf(@Param("cpf") String cpf);

	boolean existsByCpf(String cpf);
	
	public List<String> findBysolicitaExclusaoTrue();

	@Query("SELECT m.cpf FROM Municipe m WHERE m.solicitaExclusao = ?1")
	public List<String> listRequiresExclusion();
	
	//Não está funcionando
	@Modifying
	@Query("UPDATE Municipe m SET m.solicitaExclusao = 1 WHERE m.cpf = (:cpf)")
	public void includeExclusionRequest (@Param("cpf") String cpf);
	
	
	//@Query("SELECT b.descricao FROM Bairro b WHERE b.regiao= (:regiao)")
	//public List<String> findBairroByRegiao(@Param("regiao") String regiao);		

}

/*
 * Exemplo
 * 
 * @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.login= (:login)")
 * public Usuario findByLogin(@Param("login") String login);
 * 
 * boolean existsByUsername(String login);
 */
