package com.interview.java.designpatterns.rxjavadesign;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CompletableObserver {

    public static void main(String[] args) throws Exception{

        //Works just like a Runnable task
        //create a disposable observer
        Disposable disposable = Completable.complete().delay(2, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableCompletableObserver(){

            @Override
            public void onComplete() {
                System.out.println("Completed:");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        Thread.sleep(3000);
        //start listening to it
        disposable.dispose();
    }
}
