package Java.src.DesignPatterns.Factory;

public class PC extends Computer {

    private String  ram;
    private String cpu;
    private String  hdd;

    public PC(String ram,String hdd, String cpu){
        this.ram = ram;
        this.hdd= hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getCpu() {
        return this.cpu;
    }

    @Override
    public String getHdd() {
        return this.hdd;
    }
}
