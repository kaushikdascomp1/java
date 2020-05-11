package com.interview.java.designpatterns.rxjavadesign;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableMaybeObserver;

public class ReactiveOperators {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};

        Observable.fromArray(letters).map(String::toUpperCase).subscribe(letter->stringBuilder.append(letter));
        System.out.println(stringBuilder);

        //without transformation
        StringBuilder stringBuilderWithoutTransformation = new StringBuilder();
        Observable.fromArray(letters).subscribe(letter->stringBuilderWithoutTransformation.append(letter));
        System.out.println(stringBuilderWithoutTransformation);

        //filtering
        StringBuilder stringBuilder1 = new StringBuilder();
        Observable.fromArray(letters).map(String::toUpperCase).filter(e->e.equals("E")).subscribe(letter->stringBuilder1.append(letter));
        //should print E
        System.out.println(stringBuilder1);

        //Combining Observers example
        Integer[] numbers = { 1, 2, 3, 4, 5, 6};
        StringBuilder stringBuilder2 = new StringBuilder();

        Observable<String> observable1 = Observable.fromArray(letters);
        Observable<Integer> observable2 = Observable.fromArray(numbers);

        Observable.combineLatest(observable1,observable2,(a,b)->a+b).subscribe(l->stringBuilder2.append(l));
        System.out.println(stringBuilder2);

    }
}
