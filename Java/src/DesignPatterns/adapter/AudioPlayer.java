package Java.src.DesignPatterns.adapter;

public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //default behaviour as it can play only MP3 files
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing MP3 Songs" +fileName);
        }

        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4") ){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }


    }
}
