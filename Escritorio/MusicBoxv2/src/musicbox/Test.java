package musicbox;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

public class Test {
    public static void main(String[] args)throws Exception{
        BasicConfigurator.configure(new NullAppender());
        MusicBox track = new MusicBox();
        //track.AbrirFichero("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp");
        //track.reproduceMP3("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp3");
        //track.Play();

        GetMetaData getData = new GetMetaData ();
        getData.getMetaData("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp3");
        
        ArrayList list = new ArrayList ();
        
        
        GetMetaData Files = new GetMetaData ();
        //Files.listDirectory("/media/andres/Datos/Music/(+44)/When Your Heart Stops Beating");
        //Files.getExtensionFile("Make You Smile.mp3");
        Files.getAllMetaData();
    }
}
