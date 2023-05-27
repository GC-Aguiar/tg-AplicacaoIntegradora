package taubate.fatec.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Municipe;
import taubate.fatec.tg.repository.MunicipeRepository;

@Service
public class MunicipeService {
	
	@Autowired
	private MunicipeRepository repository;
	
	public List<Municipe> buscarMunicipes(){
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	
	public Optional<Municipe> buscarMunicipePorId(Integer id){
		System.out.println(repository.findById(id));
		return repository.findById(id);
	}
	public Municipe buscarMunicipePorCpf(String cpf){		
		return repository.findMunicipeByCpf(cpf);
	}
	
	public void gravarMunicipe(Municipe municipe) {
		if(municipe.getCodigo() == null) {
			repository.save(municipe);
		}else {
			System.out.println("Erro - O campo Código do munícipe não deve ser preeenchido");
		}		
	}
	
	public void deletarMunicipe(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarMunicipe(Municipe municipe, Integer id) {

        if(municipe.getCodigo().equals(id) && repository.existsById(id)){
        	System.out.println("Validação OK");
        	repository.save(municipe); //Precisa receber todos os dados // Precisa passar o ID
        }else {
        	System.out.println("Erro na Validação");
        } 				
	}

}
