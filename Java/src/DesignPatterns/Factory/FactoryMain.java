package Java.src.DesignPatterns.Factory;

public class FactoryMain {

    public static Computer getComputer(String c, String ram, String hdd, String dd){

        Computer computer = null;
        switch (c){
            case "pc":
                computer = new PC(ram,hdd,dd);
            case "server":
                computer = new Server(ram,hdd,dd);
        }

        return computer;
    }

    public static void main(String[] args) {

    }

}
