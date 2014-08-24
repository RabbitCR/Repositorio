package musicbox;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;

public class MusicBox {
    public BasicPlayer player;

    public MusicBox() {
        player = new BasicPlayer();
    }
public void coge(String y){

}
    public void reproducir() throws Exception {
        player.play();
    }

    public void abrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void pausa() throws Exception {
        player.pause();
    }

    public void continuar() throws Exception {
        player.resume();
    }

    public void detener() throws Exception {
        player.stop();
    }
    
    public static void reproduceMP3 (String ruta) throws Exception{
       try {
        MusicBox   mi_reproductor = new MusicBox();
            mi_reproductor.abrirFichero(ruta);
            mi_reproductor.reproducir();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
