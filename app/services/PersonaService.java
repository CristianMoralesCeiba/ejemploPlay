package services;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.Persona;
import domain.PersonaRepository;

///@Singleton
public class PersonaService {
	
    private final PersonaRepository personRepository;
	
    //@Inject
    public PersonaService(PersonaRepository personRepository) {
        this.personRepository = personRepository;
    }
    
	public CompletionStage<Persona> crearPersona(Persona persona) {
        return personRepository.add(persona).thenApplyAsync(p -> {
            return p;
        });
	}
	
}
