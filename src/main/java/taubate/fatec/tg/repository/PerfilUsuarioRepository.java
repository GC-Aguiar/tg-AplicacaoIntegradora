package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.PerfilUsuario;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Integer>{
	
	//Queries personalizadas
	 @Query("SELECT p.descricao FROM PerfilUsuario p WHERE p.status = (:status)")
	 public List<String> findPerfilUsuarioByStatus(@Param("status") String status);

}
