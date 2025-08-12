package com.mycompany.project_reactor_features;

import com.mycompany.project_reactor_features.pipelines.PipelineSumAllPricesInDiscount;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;

@Log
public class ProjectReactorFeaturesApplication {

	public static void main(String[] args) {

		PipelineSumAllPricesInDiscount.getSumAlIPricesInDiscount()
		.subscribe(System.out::println);
		
		/*
		*
		*
		Flux<String> flux =Flux.just("Java", "Spring", "Reactor", "mongo")
			.doOnNext( value -> log.info( "[onNext]: " + value))
			.doOnComplete(() -> log.info( "[onComplete]: Success"));

		// Consumer
		flux.subscribe(
			data -> log.info( "Receiving: " + data),
			err -> log.info( "Error: " + err.getMessage()),
			() -> log.info( "Completed success")
		);
		*/
		
		/* 
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
		*/
	}
}
