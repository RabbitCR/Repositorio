package musicbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static musicbox.MusicBox.song;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetMetaData {
    
    public static String location;
        
    public void setLocation (String location){
        this.location = location;
    }
    
    public static ListaEnlazada getMetaData (String link){
        ListaEnlazada list = new ListaEnlazada ();
        try {
            MP3File mp3File = new MP3File(link);
            InputStream input = new FileInputStream(new File(link));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();
            
            list.agregar(metadata.get("title"),metadata.get("xmpDM:artist"),metadata.get("xmpDM:genre"),metadata.get("xmpDM:album"),metadata.get("xmpDM:trackNumber"), mp3File.getMP3AudioHeader().getTrackLengthAsString() );
        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
        } 
        catch (SAXException | TikaException e) {
        } catch (TagException ex) {
            Logger.getLogger(GetMetaData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ReadOnlyFileException ex) {
            Logger.getLogger(GetMetaData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAudioFrameException ex) {
            Logger.getLogger(GetMetaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
    public static ListaDoble getAllMetaData (){
        int actual = 0;
        ListaDoble listDirectory = listDirectory();
        ListaDoble dataList = new ListaDoble();
        for (int i = 0; i < listDirectory.LargoLista(); i++){
            dataList.InsFinal(getMetaData(location+ listDirectory.obtenerElementoEnPosicionO(actual)));
            actual++;
        }
        return dataList;
    }
    public static ListaDoble listDirectory (){
        String sDirectorio = location;
        ListaDoble listFiles = new ListaDoble();
        File f = new File(sDirectorio);
    
        if (f.exists()){ 
            File[] ficheros = f.listFiles();
            for (int x=0; x < ficheros.length; x++){
                listFiles.InsFinalO(ficheros[x].getName());
                //System.out.println(ficheros[x].getName());
                
            }
        }
        else {
            System.out.println("Invalid Directory");
        }
        //listFiles.Imprimir();
        return filtrarElementos(listFiles);
    }
    
    public static ListaDoble filtrarElementos (ListaDoble list){
        int actual = 0;
        ListaDoble tracks = new ListaDoble();
        ListaDoble folders = new ListaDoble();
        for (int i = 0; i < list.LargoLista(); i++){
            //System.out.println("1");
            if (getExtensionFile(list.obtenerElementoEnPosicionO(actual).toString()).equals("mp3")){
                //System.out.println("1");
                tracks.InsFinalO(list.obtenerElementoEnPosicionO(actual));
            }
            else{
                //System.out.println("0");
                folders.InsFinalO(list.obtenerElementoEnPosicionO(actual));
            }
            actual++;
        }
        return tracks;
    }
      
    public static String getExtensionFile(String filename) {
                int index = filename.lastIndexOf('.');
                if (index == -1) {
                    return "";
                } 
                else {
                    return filename.substring(index + 1);
                }
    }
    
    public void getData (){
        ListaEnlazada x = getAllMetaData().obtenerElementoEnPosicion(0);
        x.obtenerDato1();
        x.obtenerDato2();
        x.obtenerDato3();
        x.obtenerDato4();
        x.obtenerDato5();
        x.obtenerDato6();
        
    }     
}