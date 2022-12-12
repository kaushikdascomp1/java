package com.interview.java.designpatterns.multithreaded.foobaralt;

public class FooBar {

    private int n;
    private int flag = 0;

    public FooBar(int n){
        this.n = n;
    }

    //Flag 0 will print Foo whereas when Flag 1 will print Bar
    //And this should go on alternatively one time Foo and one time Bar
    public void printFoo() throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while (flag == 1){
                    this.wait();
                }
                System.out.println("Printing Foo");
                flag = 1;
                this.notifyAll();
            }

        }
    }

    public void printBar() throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while (flag == 0){
                    this.wait();
                }
                System.out.println("Printing Bar");
                flag = 0;
                this.notifyAll();
            }

        }
    }
}
