package br.edu.ifgoias.academico.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.CursoService;

@RestController
@RequestMapping (value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity< List<Curso> > findAll(){
		
		List<Curso> cursos = service.findAll();
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping  ( value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id){
		
		Curso curso = service.findById(id);
		return ResponseEntity.ok().body(curso);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Curso> insert(@RequestBody Curso c){
		c = service.insert(c);
		return ResponseEntity.ok().body(c);
	}
	
	@DeleteMapping ( value = "/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
	@PutMapping( value = "/{id}")
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso c){
		c = service.update(id, c);
		return ResponseEntity.ok().body(c);
	}
}
