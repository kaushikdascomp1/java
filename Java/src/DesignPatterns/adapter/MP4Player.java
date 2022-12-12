package DesignPatterns.adapter;

public class MP4Player implements AdvancedMediaPlayer {

    @Override
    public void playVLC(String fileName) {
        //DO nothing
    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 files:: "+fileName);
    }
}
