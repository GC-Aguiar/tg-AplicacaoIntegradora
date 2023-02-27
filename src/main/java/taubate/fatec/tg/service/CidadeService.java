package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import taubate.fatec.tg.model.Cidade;
import taubate.fatec.tg.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> buscarCidades(){
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public Optional<Cidade> buscarCidadePorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarCidadePorCodigoUf(Integer UfCodigo){
		
		return repository.findCidadeByUf(UfCodigo);
	}
	
	public void gravarCidade(Cidade cidade) {
		repository.save(cidade);
	}
	
	public void deletarCidade(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarCidade(Cidade cidade, Integer id) {
		/*
        Employee updateEmployee = employeeRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		 */
		
		repository.save(cidade);
	}
	

}
