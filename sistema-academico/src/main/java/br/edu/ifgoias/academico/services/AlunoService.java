package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRep;

	public List<Aluno> findAll() {
		return alunoRep.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRep.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Aluno insert(Aluno obj) {
		return alunoRep.save(obj);
	}

	public void delete(Integer id) {
		alunoRep.deleteById(id);
	}

	public Aluno update(Integer id, Aluno obj) {
		return alunoRep.findById(id).map(
									aluno -> {
												aluno.setNome( obj.getNome() );
												return alunoRep.save(aluno);  
											 }
								).orElseThrow(
									() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
								);
	}

}
