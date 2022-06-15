package br.edu.ifgoias.academico.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.entities.repositories.AlunoRepository;
import br.edu.ifgoias.academico.entities.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner {

	/*
	 * @Autowired private CursoRepository cursoRep;
	 */
	
	@Autowired
	private AlunoRepository alunoRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Date datebirth = parseDate("2014-02-14");
		Aluno a1 = new Aluno("Adrian Shum", "Masculino", datebirth);
		alunoRep.save(a1);
		
		
		
		//Curso c1 = new Curso(null,"POO III");
		//Curso c2 = new Curso(null,"EAD II");

		//cursoRep.save(c1);
		//cursoRep.save(c2);
		
		//cursoRep.delete(c1);
		 
		//System.out.println("Qtde Cursos: " + cursoRep.count()) ;
	}

	public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     } //cortesia de Adrian Shum: https://stackoverflow.com/questions/22326339/how-create-date-object-with-values-in-java
  }

}
