package controllers;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import domain.Persona;
import domain.PersonaRepository;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;


public class PersonaController extends Controller{

    private final HttpExecutionContext ec;
    private final PersonaRepository personaRepository;
	
    @Inject
    public PersonaController(HttpExecutionContext ec, PersonaRepository personaRepository) {
        this.ec = ec;
        this.personaRepository = personaRepository;
    }
    

	@BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> addPerson() {
		JsonNode body = request().body().asJson();
		Persona persona = Json.fromJson(body, Persona.class);
        return personaRepository.add(persona).thenApplyAsync(p -> {
            return created(Json.toJson(p));
        }, ec.current());
    }
    
    
    public Result index() {
        return ok("hola");
    }
    
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result crear () {
		
		
		return ok("Se creo");
	}
	
	public Result listar (){return null;}
	public Result buscar (String cedula){return null;}
	public Result borrar (String cedula){return null;}
	
}
