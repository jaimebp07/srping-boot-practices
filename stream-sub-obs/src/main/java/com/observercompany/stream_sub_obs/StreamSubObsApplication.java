package com.observercompany.stream_sub_obs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class StreamSubObsApplication {

	public static void main(String[] args) {
		final ReactiveStream<String> stringStream = new ReactiveStream<>();
		final ReactiveStream<Integer> intStream = new ReactiveStream<>(); //

		final String subsName1 = "Subscriber1";
		final String subsName2 = "Subscriber2";
		final String subsName3 = "Subscriber3";
		final String subsName4 = "Subscriber4";

		final Subscriber<String> strSubs1 = new SubscriberImpl<>(
			str -> "Length: " + str.length(),
			subsName1
		);

		final Subscriber<String> strSubs2 = new SubscriberImpl<>(
			String :: toUpperCase,
			subsName2
		);

		final Subscriber<Integer> intSubs1 = new SubscriberImpl<>(
			num -> "Value: " + num,
			subsName3
		);

		final Subscriber<Integer> intSubs2 = new SubscriberImpl<>(
			num -> "Square: " + (num * num),
			subsName4
		);

		stringStream
			.subscribe(strSubs1)
			.subscribe(strSubs2);

		intStream
			.subscribe(intSubs1)
			.subscribe(intSubs2);


		log.info(" --- [Strings] --- ");
		stringStream.emit( "hello world");
		stringStream.emit( "this is a subscriber");
		stringStream.emit( "debuggeando ideas");


		log.info(" --- [Numbers] --- ");
		intStream.emit( 5);
		intStream.emit( 10);
		intStream.emit( 30);
		intStream.emit( 3000);

		stringStream.unsubscribe(strSubs2);
		intStream.unsubscribe(intSubs1);
		intStream.unsubscribe(intSubs2);
	}

}
