package musicbox;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

public class Test {
    public static void main(String[] args)throws Exception{
        
        BasicConfigurator.configure(new NullAppender());
        MusicBox track = new MusicBox();
        GetMetaData Files = new GetMetaData ();
        ArrayList list = new ArrayList ();
        Arrange sort = new Arrange();
        
        Files.setLocation("/media/andres/Datos/Music/(+44)/When Your Heart Stops Beating/");
        track.setSong("Make You Smile.mp3");
        
        //track.playMP3(); 
        track.previous();
        //track.next();
        //Files.getData();
        
        sort.bySong();        
    }
}
