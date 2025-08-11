package com.observercompany.stream_sub_obs;

public interface Subscriber<T> {

    void onNext(T next);
    String getName();

}
