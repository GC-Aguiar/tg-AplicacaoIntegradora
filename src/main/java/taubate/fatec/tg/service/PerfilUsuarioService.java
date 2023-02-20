package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.PerfilUsuario;
import taubate.fatec.tg.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	
	@Autowired
	private PerfilUsuarioRepository repository;
	
	public List<PerfilUsuario> buscarPerfisUsuario(){
		System.out.println(repository.findAll()); // Para mostrar no console
		return repository.findAll();
	}
	
	public Optional<PerfilUsuario> buscarPerfilUsuarioPorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarPerfilUsuarioPorStatus(String status){
		
		return repository.findPerfilUsuarioByStatus(status);
	}


}
