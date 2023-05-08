package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.SistemaExterno;
import taubate.fatec.tg.repository.SistemaExternoRepository;

@Service
public class SistemaExternoService {
	
	@Autowired
	private SistemaExternoRepository repository;
	
	public List<SistemaExterno> buscarSistemasExternos(){
		System.out.println(repository.findAll()); // Para mostrar no console
		return repository.findAll();
	}
	
	public Optional<SistemaExterno> buscarSistemaExternoPorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarSistemaExternoPorStatus(String status){
		
		return repository.findSistemaExternoByStatus(status);
	}
	
	public void gravarSistemaExterno (SistemaExterno sistemaExterno) {
		repository.save(sistemaExterno);
	}
	
	public void deletarSistemaExterno(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarSistemaExterno (SistemaExterno sistemaExterno, Integer id) {
        if(sistemaExterno.getCodigo().equals(id) && repository.existsById(id)){
        	System.out.println("Validação OK");
        	repository.save(sistemaExterno); //Precisa receber todos os dados // Precisa passar o ID
        }else {
        	System.out.println("Erro na Validação");
        }
	}


}
