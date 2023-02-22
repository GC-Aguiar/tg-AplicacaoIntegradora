package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository repository;
	
	public void gravarUsuario(Usuario usuario) {
		System.out.println("Gravando Usuário");
		repository.save(usuario);
		
	}
	public void alterarUsuario(Usuario usuario) {
		System.out.println("Alterando Usuário");
		repository.save(usuario);
		// TODO		
	}
	
	public Optional<Usuario> buscarUsuarioPorId(Integer id){
		System.out.println("Buscando Usuário por ID");
		return repository.findById(id);
	}
	public Usuario buscarUsuarioPorLogin(String login) {
		System.out.println("Buscando usuário pelo login");
		return null;
	}
	public List<Usuario> buscarUsuarios() {
		System.out.println("Listando todos os Usuário");
		return repository.findAll();		
	}
}
