package Java.src.DesignPatterns.adapter;

public class VLCPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing file in VLC:: "+fileName);
    }

    @Override
    public void playMP4(String fileName) {
        //DO nothing
    }
}
