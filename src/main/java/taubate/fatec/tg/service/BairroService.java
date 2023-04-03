package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Bairro;
import taubate.fatec.tg.repository.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository repository;
	
	public List<Bairro> buscarBairros(){
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public Optional<Bairro> buscarBairroPorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarBairroPorRegiao(String regiao){
		
		return repository.findBairroByRegiao(regiao);
	}
	
	public void gravarBairro(Bairro bairro) {
		repository.save(bairro);
	}
	
	public void deletarBairro(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarBairro(Bairro bairro, Integer id) {
		/*
		         Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		 */
		
        if(bairro.getCodigo().equals(id) && repository.findById(id).equals(bairro)) {
        	repository.save(bairro); //Precisa receber todos os dados do bairro // Precisa passar o ID
        }
		
		
		
	}
	
	

}
