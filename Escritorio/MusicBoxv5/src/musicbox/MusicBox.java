package musicbox;
import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import static musicbox.GetMetaData.getAllMetaData;
import static musicbox.GetMetaData.location;

public class MusicBox {
    public static String song;
    private static int actual;
    private static ListaDoble list = new ListaDoble();
    
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
        int counter = 0;
        list = getAllMetaData();
        while (list.LargoLista() != actual){
            if((list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3").equals(song)){
                break; 
            }
            counter++;
            actual++;
        }
        actual = Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString());
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
        int counter = 0;
        list = getAllMetaData();
        while (list.LargoLista() != actual){
            if((list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3").equals(song)){
                break; 
            }
            counter++;
            actual++;
        }
        try {
            actual = Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString());
            counter = 0;
            while (Integer.parseInt(list.obtenerElementoEnPosicion(counter).obtenerDato5().toString()) != actual + 1 ){
                counter++;
            }
            setSong (list.obtenerElementoEnPosicion(counter).obtenerDato1().toString() + ".mp3");
            playMP3();
        }
        catch (java.lang.NullPointerException e){
        }
    }
    
    public static void playMP3 () throws Exception{
       try {
        MusicBox   mi_reproductor = new MusicBox();
            mi_reproductor.openFile(location + song);
            mi_reproductor.play();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}