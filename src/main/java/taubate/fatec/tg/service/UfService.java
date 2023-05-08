package taubate.fatec.tg.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taubate.fatec.tg.model.Bairro;
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
		
	public void gravarUf(Uf uf) {
		repository.save(uf);
	}
	
	public void deletarUf(Integer id) {
		repository.deleteById(id);
	}
	
	public void alterarUf(Uf uf, Integer id) {

        if(uf.getCodigo().equals(id) && repository.existsById(id)){
        	System.out.println("Validação OK");
        	
        	Calendar calendario = Calendar.getInstance();
            Date dataAtual = calendario.getTime();
            System.out.println("Data atual: " + dataAtual);
            
        	
        	repository.save(uf); //Precisa receber todos os dados do bairro // Precisa passar o ID
        }else {
        	System.out.println("Erro na Validação");
        } 				
	}

}
