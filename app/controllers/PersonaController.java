package controllers;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import domain.Persona;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.PersonaService;


public class PersonaController extends Controller{

    private final HttpExecutionContext ec;
    private final PersonaService personaService;
	
    @Inject
    public PersonaController(HttpExecutionContext ec, PersonaService personaService) {
        this.ec = ec;
        this.personaService = personaService;
    }
    

	@BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> crear() {
		JsonNode body = request().body().asJson();
		Persona persona = Json.fromJson(body, Persona.class);
        return personaService.crear(persona).thenApplyAsync(p -> {
            return created(Json.toJson(p));
        }, ec.current());
    }
    
	
	public CompletionStage<Result> listar (){return null;}
	public Result buscar (String cedula){return null;}
	public Result borrar (String cedula){return null;}
	
}
