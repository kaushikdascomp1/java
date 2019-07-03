package Java.src;

import Java.src.Printer;

public class OddEven implements Runnable{
    private Printer printer;
    private int max;
    private boolean isEvenNumber;

public OddEven(Printer printer, int max, boolean isEvenNumber){
    this.printer=printer;
    this.max=max;
    this.isEvenNumber=isEvenNumber;
}

    @Override
    public void run() {
        int number = isEvenNumber ? 2 :1;
        while(number <= max){
            if(isEvenNumber){
                printer.printEven(number);
            }else{
                printer.printOdd(number);
            }
            number +=2;
        }
    }
}
