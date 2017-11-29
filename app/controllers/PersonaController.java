package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import domain.Persona;
import play.libs.Json;
import play.mvc.*;


public class PersonaController extends Controller{

	@BodyParser.Of(BodyParser.Json.class)
	public Result crear () {
		JsonNode body = request().body().asJson();
		Persona persona = Json.fromJson(body, Persona.class);
		
		return ok("Se creo");
	}
	
	public Result listar (){return null;}
	public Result buscar (String cedula){return null;}
	public Result borrar (String cedula){return null;}
	
}
