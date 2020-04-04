package Java.src.CustomImplementation.CustomThreadPool;

import Java.src.CustomImplementation.Task;
import Java.src.CustomImplementation.ThreadPool;

public class CustomThreadPoolMain {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(7);
        //Create 5 tasks
        for(int i=0;i<5;i++){
            Task task = new Task(i);
            threadPool.execute(task);
        }


    }
}
