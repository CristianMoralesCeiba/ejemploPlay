package domain;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAPersonaRepository.class)
public interface PersonaRepository {

    CompletionStage<Persona> add(Persona person);

    CompletionStage<Stream<Persona>> list();
}
