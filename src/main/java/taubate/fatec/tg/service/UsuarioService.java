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
	public void alterarUsuario(Usuario usuario, Integer id) {
		if(usuario.getCodigo().equals(id) && repository.existsById(id)){
        	System.out.println("Validação OK");
        	repository.save(usuario); //Precisa receber todos os dados// Precisa passar o ID
        }else {
        	System.out.println("Erro na Validação");
        }
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
	
	public void deletarUsuario(Integer id) {
		repository.deleteById(id);
	}
}
