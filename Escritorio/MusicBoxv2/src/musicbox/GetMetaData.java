package musicbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetMetaData {
    
    private class metaData{
        private String location;
        
        public void setLocation (String location){
            this.location = location;
        }
        public String getLocation (){
            return this.location;
        }
    }
    
    public static ArrayList getMetaData (String location){
        ArrayList infoList = new ArrayList();

        try {

            InputStream input = new FileInputStream(new File(location));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            infoList.add("Title: " + metadata.get("title"));
            infoList.add("Artists: " + metadata.get("xmpDM:artist"));
            infoList.add("Composer : "+metadata.get("xmpDM:composer"));
            infoList.add("Genre : "+metadata.get("xmpDM:genre"));
            infoList.add("Album : "+metadata.get("xmpDM:album"));
            infoList.toString();

        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
        } 
        catch (SAXException | TikaException e) {
        }
        return infoList;
    }
    
    public void getAllMetaData(){
        int actual = 0;
        String location = "/media/andres/Datos/Music/(+44)/When Your Heart Stops Beating/";
        ListaDoblementeEnlazada list = listDirectory("/media/andres/Datos/Music/(+44)/When Your Heart Stops Beating");
        for (int index = 0; index < list.size(); index++){
            getMetaData(location + list.obtenerElementoEnPosicion(actual));
            actual++;
        }
    }
    
    public static ListaDoblementeEnlazada listDirectory(String location){
        String sDirectorio = location;
        ListaDoblementeEnlazada listFiles = new ListaDoblementeEnlazada ();
        File f = new File(sDirectorio);
    
        if (f.exists()){ 
            File[] ficheros = f.listFiles();
            for (int x=0; x < ficheros.length; x++){
                listFiles.agregar(ficheros[x].getName());
                
            }
        }
        else {
            System.out.println("Invalid Directory");
        }
        return filtrarElementos(listFiles);
        
    }
    
    public static ListaDoblementeEnlazada filtrarElementos (ListaDoblementeEnlazada list){
        int actual = 0;
        ListaDoblementeEnlazada tracks = new ListaDoblementeEnlazada();
        for (int index = 0; index < list.size(); index++){
            if (getExtensionFile(list.obtenerElementoEnPosicion(actual)).equals("mp3")){
                tracks.agregar(list.obtenerElementoEnPosicion(actual));
            }
            else{
                
            }
            actual++;
        }
        //tracks.toString();
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
    
    public void arrayBy (String type){
        for (int index = 0; index < this.getMetaData(type).getSize(); index++){
            
        }
        
    }

}
