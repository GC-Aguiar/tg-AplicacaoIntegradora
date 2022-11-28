package taubate.fatec.tg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository repository;
	
	public void gravar(Usuario usuario) {
		System.out.println("Gravando Usuário");
	}
	public void alterar(Usuario usuario) {
		System.out.println("Alterando Usuário");
	}
	public Usuario buscarPorLogin(String login) {
		System.out.println("Buscando usuário pelo login");
		return null;
	}
	public List<Usuario> lista() {
		System.out.println("Listando todos os Usuário");
		return null;
	}
}
