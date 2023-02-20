package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Empresa;
import taubate.fatec.tg.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> buscarEmpresas(){
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public Optional<Empresa> buscarEmpresaPorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public List<String> buscarEmpresaPorCnpj(Integer cnpj){
		
		return repository.findEmpresaByCnpj(cnpj);
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
