package musicbox;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;
import org.farng.mp3.TagOptionSingleton;

public class Test {
    public static void main(String[] args)throws Exception{
        
        BasicConfigurator.configure(new NullAppender());
        MusicBox track = new MusicBox();
        GetMetaData Files = new GetMetaData ();
        ArrayList list = new ArrayList ();
        Arrange sort = new Arrange();
        
        Files.setLocation("C:/Users/lconejo/Desktop/TP1 Datos/MusicBox/song/");
        track.setSong("Make You Smile.mp3");
        
        //track.playMP3(); 
        //track.previous();
        //track.next();
        //track.randomPlayer();
        track.playerList();
        //Files.getAllMetaData();
                
        //sort.bySong();        
    }
}
