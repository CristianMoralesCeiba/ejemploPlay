package services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.Persona;
import domain.PersonaRepository;
import play.libs.concurrent.HttpExecutionContext;

@Singleton
public class PersonaService {
	
    private final PersonaRepository personRepository;
    private final HttpExecutionContext ec;
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("application");

	
    @Inject
    public PersonaService(PersonaRepository personRepository, HttpExecutionContext ec) {
        this.personRepository = personRepository;
        this.ec = ec;
    }
    
	public CompletionStage<Persona> crear(Persona persona) {
		CompletionStage<String> holas;
		CompletionStage<String> chao;
		
		logger.info("Root " + Thread.currentThread().getId());
		holas = hola().thenApplyAsync(answer -> {
           return answer;
        }, ec.current());
		
		
		chao = chao().thenApplyAsync(answer -> {
	           return answer;
	        }, ec.current());
		
        return personRepository.add(persona).thenApplyAsync(p -> {
            return p;
        });
	}		
	
	
	private CompletionStage<String> hola () {
		logger.info("Hola " + Thread.currentThread().getId());
		return CompletableFuture.completedFuture("Hola");
	}
	
	private CompletionStage<String> chao () {
		logger.info("Chao " + Thread.currentThread().getId());
		return CompletableFuture.completedFuture("Bye");
	}
}
