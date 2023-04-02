package taubate.fatec.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import taubate.fatec.tg.model.Municipe;
import taubate.fatec.tg.repository.MunicipeRepository;

@Service
public class LgpdService {
	
	private MunicipeRepository repository;
	
	public List<String> buscarLgpd () {		
		return repository.listRequiresExclusion();
	}
	
	public void inserirLgpd(@RequestBody String cpf) {
		repository.includeExclusionRequest(cpf);
	}

}
