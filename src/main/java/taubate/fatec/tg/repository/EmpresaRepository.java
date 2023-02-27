package taubate.fatec.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	//Queries personalizadas
	 @Query("SELECT e.descricao FROM Empresa e WHERE e.cnpj= (:cnpj)")
	 public List<String> findEmpresaByCnpj(@Param("cnpj") String cnpj);

}
