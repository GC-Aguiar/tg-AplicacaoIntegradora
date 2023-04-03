package taubate.fatec.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import taubate.fatec.tg.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

	
	/*
	@Modifying
	@Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
	void setUserInfoById(String firstname, String lastname, Integer userId);
	 */
	
	Usuario findByLogin(String login);
}
