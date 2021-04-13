package com.interview.java.designpatterns.rxjavadesign;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MayBeObserver {

    public static void main(String[] args) throws Exception{

        //creating an observable
        Maybe<String> justObservable = Maybe.just("Hello World!!");

        //create an observer
        Disposable disposable = justObservable.delay(2, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableMaybeObserver<>(){
            @Override
            public void onSuccess(String string) {
                System.out.println("May Be Observer completed:: "+string);
            }

            @Override
            public void onComplete() {
                System.out.println("Manually completing an observer::  ");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        //start listening
        Thread.sleep(3000);
        disposable.dispose();
    }
}
