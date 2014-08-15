package musicbox;

import org.apache.log4j.BasicConfigurator;

public class Test {
    public static void main(String[] args)throws Exception{
        BasicConfigurator.configure();
        MusicBox track = new MusicBox();
        track.AbrirFichero("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp3");
        track.Play();

        GetMetaData getData = new GetMetaData ();
        getData.getMetaData("/home/andres/NetBeansProjects/MusicBox/src/Make You Smile.mp3");      
        
    }
}
