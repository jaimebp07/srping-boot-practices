package com.mycompany.project_reactor_features;

import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@Log
public class ProjectReactorFeaturesApplication {

	public static void main(String[] args) {
		// Publisher
		Mono<String> mono = Mono.just( "Hello World")
			.doOnNext( value -> log.info("[onNext]: " + value))//Acción que se ejecuta cuando el valor pasa por el stream antes de llegar al suscriptor.
			.doOnSuccess( value -> log.info( "[onSuccess]: " + value)) //Acción cuando el Mono termina con éxito
			.doOnError( err -> log.info(err.getMessage()));

		// Consumer
		mono.subscribe(
			data -> log.info( "Receiving data:" + data), //onNext → Qué hacer cuando llega un dato (data).
			err -> log.info( "Error: " + err.getMessage()), //onError → Qué hacer si ocurre un error (err).
			() -> log.info( "Complete success!") //onComplete → Qué hacer cuando el flujo termina con éxito.
		);
	}
}
