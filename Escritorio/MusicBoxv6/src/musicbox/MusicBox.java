package musicbox;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javazoom.jlgui.basicplayer.BasicPlayer;
import musicbox.Cola;
import static musicbox.GetMetaData.getAllMetaData;
import static musicbox.GetMetaData.location;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;

public class MusicBox {
    public static String song;
    private static int actual;
    private static int counter;
    private static ListaDoble list = new ListaDoble();
    private static Cola playerList = new Cola();
    
    public void setSong(String songName){
        this.song = songName;
    }
    public BasicPlayer player;

    public MusicBox() {
        player = new BasicPlayer();
    }

    public void play() throws Exception {
        player.play();
    }

    public void openFile(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void pause() throws Exception {
        player.pause();
    }

    public void resume() throws Exception {
        player.resume();
    }

    public void stop() throws Exception {
        player.stop();
    }
    
    public void previous() throws Exception {
        stop();
        actual = getActual();
        counter = 0;
        try {
            while (Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString()) != actual - 1){
                counter++;
            }
            setSong (list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3");
            playMP3();
        }
        catch (java.lang.NullPointerException e){ 
        }
    }
    
    public void next() throws Exception {
        stop();
        actual = getActual();
        counter = 0;
        try {
            while (Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString()) != actual + 1){
                counter++;
            }
            setSong (list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3");
            playMP3();
        }
        catch (java.lang.NullPointerException e){ 
        }
    }
    
    public static void playMP3 () throws Exception {
        try {
            MusicBox   mi_reproductor = new MusicBox();
            mi_reproductor.openFile(location + song);
            mi_reproductor.play();
        } 
        catch (Exception ex) {
        }
    }
    
    public void randomPlayer() throws Exception{
        stop();
        list =getAllMetaData();
        actual = randomGenerator(0, list.LargoLista());
        setSong (list.obtenerElementoEnPosicion(actual).obtenerDato1().toString() + ".mp3");
        playMP3();
    }
    
    public static int randomGenerator(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public void playerList() throws Exception {
        actual = getActual();
        actual++;
        playMP3();
        delayEffect(getTrackLenght(location + song)*1000);
        counter = list.LargoLista() - actual;
        actual = Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString());
        while (counter != 0){
            try{
                if (counter == 1){
                    next();
                    break;
                }
                next();
                delayEffect(getTrackLenght(location + song)*1000);
                counter--; 
            }
            catch (java.lang.NullPointerException e) {
            }
        }
    }

    public static int getActual (){
        list = getAllMetaData();
        while (list.LargoLista() != actual){
            if((list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3").equals(song)){
                break; 
            }
            counter++;
            actual++;
        }
        try{
            actual = Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString());
        }
        catch (java.lang.NumberFormatException e){}
        return actual;
    }
    
    public static void delayEffect (int time){
        try {
            Thread.sleep(time);    // one second
        }

        catch (Exception e) {
        }                       
    }
    
    public static int getTrackLenght (String track) throws IOException, org.jaudiotagger.tag.TagException, ReadOnlyFileException, InvalidAudioFrameException{
        MP3File mp3File = new MP3File(track);
        return mp3File.getMP3AudioHeader().getTrackLength();
    }
    
}