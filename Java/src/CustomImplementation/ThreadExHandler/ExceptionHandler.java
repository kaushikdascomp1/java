package Java.src.CustomImplementation.ThreadExHandler;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An exception Occurred::");
        System.out.println("Thread Id:  "+t.getId());
        System.out.println("Exception in class is:: %s %s "+ e.getClass().getName()+ e.getMessage());
        System.out.println("Stacktrace is::  ");
        e.printStackTrace();
        System.out.println("Thread state:: "+t.getState());
        new Thread(()->{
            System.out.println(Integer.parseInt("123"));
            System.out.println(Integer.parseInt("943"));
            System.out.println(Integer.parseInt("XYZ"));
            System.out.println(Integer.parseInt("636"));
        }).start();
    }
}
