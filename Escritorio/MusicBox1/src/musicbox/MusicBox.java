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
    public void Play() throws Exception {
        player.play();
    }

    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void Pausa() throws Exception {
        player.pause();
    }

    public void Continuar() throws Exception {
        player.resume();
    }

    public void Stop() throws Exception {
        player.stop();
    }
    public void reproducemp3 () throws Exception{
       try {
        MusicBox   mi_reproductor = new MusicBox();
            mi_reproductor.AbrirFichero("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp3");
            mi_reproductor.Play();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
