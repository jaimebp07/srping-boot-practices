package com.observercompany.stream_sub_obs;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class SubscriberImpl<T> implements Subscriber<T> {

    private final Function<T, String> mapper;
    private final String name;
    
    @Override
    public void onNext(T next) {
        final var valueMapper = this.mapper.apply(next);
        log.info("[onNext]" + next);
        log.info("[onNext] mapper" + valueMapper);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
