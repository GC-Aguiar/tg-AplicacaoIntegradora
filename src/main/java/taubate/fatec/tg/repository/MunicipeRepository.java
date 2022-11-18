package taubate.fatec.tg.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Municipe;

@Repository
public interface MunicipeRepository extends JpaRepository<Municipe, Integer> {
	
	@Query("SELECT m FROM Municipe m WHERE m.cpf = (:cpf)")
	public Municipe findByCpf(@Param("cpf") String cpf);
	
	boolean existsByCpf(String cpf);	
	
	@Query("SELECT m FROM Municipe m WHERE m.solicitaExclusao = 1")
	public List<Municipe> listRequiresExclusion();
	//boolean requiresExclusion(String cpf);
		
	}

	/* Exemplo
	@Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.login= (:login)")
    public Usuario findByLogin(@Param("login") String login);
    
    boolean existsByUsername(String login);
    */

