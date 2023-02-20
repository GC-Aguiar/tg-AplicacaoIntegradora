package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Uf;
import taubate.fatec.tg.repository.UfRepository;

@Service
public class UfService {
	
	@Autowired
	private UfRepository repository;
	
	public List<Uf> buscarUfs(){
		System.out.println(repository.findAll()); // Para mostrar no console
		return repository.findAll();
	}
	
	public Optional<Uf> buscarUfPorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarUfPorRegiao(String regiao){
		
		return repository.findUfByRegiao(regiao);
	}
	
	
	
	/*
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
	 */

}
