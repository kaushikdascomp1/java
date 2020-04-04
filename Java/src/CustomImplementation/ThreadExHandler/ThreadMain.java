package Java.src.CustomImplementation.ThreadExHandler;

public class ThreadMain {



    public static void main(String[] args) {

        Thread.UncaughtExceptionHandler exceptionHandler = (t,  e) ->{
            System.out.println("Exception Occurred::   "+t.getId());
            System.out.println("Exception Occurred in thread name and class::   "+e.getClass().getName()+e.getMessage());
            System.out.println("Exception stack trace is::   ");
            e.printStackTrace();
            System.out.println(t.getState());
            new Thread(()->{
                System.out.println("Inside Lambda Expression:: "+ Integer.parseInt("9443"));
                System.out.println("Inside Lambda Expression:: "+ Integer.parseInt("44"));
                System.out.println("Inside Lambda Expression:: "+ Integer.parseInt("9768443"));
                System.out.println("Inside Lambda Expression:: "+ Integer.parseInt("fddg"));
                System.out.println("Inside Lambda Expression:: "+ Integer.parseInt("6878"));

            }).start();

        };

        Runnable runnable = () ->{
         Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler()); // or can use the exceptionhandler lambda above
            System.out.println("Inside main Runnable:  "+Integer.parseInt("123"));
            System.out.println("Inside main Runnable:  "+Integer.parseInt("763"));
            System.out.println("Inside main Runnable:  "+Integer.parseInt("NBV"));// Should throw error and move to uncaughtExceptionHandler
            System.out.println("Inside main Runnable:  "+Integer.parseInt("474"));
        };

        Thread th = new Thread(runnable);
        th.start();

    }
}
