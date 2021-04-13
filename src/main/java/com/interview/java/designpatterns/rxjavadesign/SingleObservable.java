package com.interview.java.designpatterns.rxjavadesign;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SingleObservable {

    public static void main(String[] args) throws Exception{
        justObserverExample();
    }

    private static void justObserverExample() throws InterruptedException {
        //creating a single just observable which emits a single value using just
        Single<String> singleObservable = Single.just("Hello World");

        //create observers from singleobservable
        Disposable disposable = singleObservable.delay(1, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableSingleObserver<String>(){
            @Override
            public void onSuccess(String string) {
                System.out.println("Success::" +string);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        Thread.sleep(2000);
        //start listening
        disposable.dispose();
    }
}
