package com.observercompany.stream_sub_obs;

import java.util.LinkedList;
import java.util.List;

import lombok.extern.java.Log;

@Log
public class ReactiveStream<T> {

    private final List<Subscriber<T>> subscribers = new LinkedList<>();

    public ReactiveStream<T> subscribe(Subscriber<T> subscriber) {
        this.subscribers.add(subscriber);
        log.info("[Subscribe] " + subscriber.getName());
        return this;
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        this.subscribers.remove(subscriber);
        log.info("[Unsubscribe] " + subscriber.getName());
    }

    public void emit(T value){
        this.subscribers.forEach(sub -> sub.onNext(value));
    }
}
