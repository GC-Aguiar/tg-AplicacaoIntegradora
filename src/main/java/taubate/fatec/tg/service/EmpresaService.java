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
	public List<String> buscarEmpresaPorCnpj(String cnpj){
		return repository.findEmpresaByCnpj(cnpj);
	}
	
	public void gravarEmpresa(Empresa empresa) {
		repository.save(empresa);
	}
	
	public void deletarEmpresa(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarEmpresa(Empresa empresa, Integer id) {
		/*
		         Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		 */
		repository.save(empresa); //Precisa receber todos os dados 
		
	}
	
	


}
