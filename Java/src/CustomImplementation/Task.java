package Java.src.CustomImplementation;

public class Task implements Runnable {

    int num;

    public Task(int num){
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println("Task Running:  "+ num + " in process::");
    }
}
